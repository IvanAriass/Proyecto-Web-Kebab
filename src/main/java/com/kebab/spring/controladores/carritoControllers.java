package com.kebab.spring.controladores;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kebab.spring.modelo.LineaPedidos;
import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Productos;
import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.servicios.CategoriasServiceDB;
import com.kebab.spring.servicios.LineaPedidosDB;
import com.kebab.spring.servicios.PedidosServiceDB;
import com.kebab.spring.servicios.ProductosServiceDB;
import com.kebab.spring.servicios.UsuariosServiceDB;

@Controller
public class carritoControllers {

	@Autowired
	private UsuariosServiceDB usuariosService;
	
	@Autowired
	private PedidosServiceDB pedidosService;
	
	@Autowired 
	private LineaPedidosDB lineaPedidosService;
	
	@Autowired
	private ProductosServiceDB productosService;
		
	@PostMapping("/carrito")
	public String Carrito(@RequestParam(name = "productoId", required = true) Long productoId, @RequestParam(name = "precioUnitario", required = true) double precioUnitario) {
				
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		
		// Obtenemos los valores que emplearemos
		Usuarios usu = usuariosService.findFirstByEmail(email);
		int pedidosTotalesUsuario = pedidosService.pedidosCarritoCount(usu, "Carrito");
		boolean condicionCumplida = false;
		
		System.out.println(pedidosTotalesUsuario);
		
		// Comprobamos si existen tablas en los pedidos de los usuarios
		if (pedidosTotalesUsuario > 0) {
			
			List<Pedidos> pedidos = pedidosService.pedidos(usu);
			
			// Función que recorre todos los pedidos
			for (Pedidos row : pedidos) {
				
				if ("Carrito".equals(row.getEstado())) {
					
					for (LineaPedidos linea : row.getLineaPedidos()) {
					    if (linea.getProducto() == productosService.findById(productoId)) {
					    	
					        linea.setCantidad(linea.getCantidad() + 1);
					        linea.setPrecioLinea(linea.getCantidad() * precioUnitario);
					        lineaPedidosService.add(linea);
					        
					        // Calculamos el precio total del pedido
				        	row.setPrecioTotal(row.getPrecioTotal() + precioUnitario);
					        pedidosService.add(row);
					        
					        condicionCumplida = true;
					        break;
					    }
					}

					if (!condicionCumplida) {
					    LineaPedidos nuevaLinea = new LineaPedidos();
					    nuevaLinea.setCantidad(1);
					    nuevaLinea.setProducto(productosService.findById(productoId));
					    nuevaLinea.setPedido(row);
					    nuevaLinea.setPrecioLinea(precioUnitario);
					    lineaPedidosService.add(nuevaLinea);
					    
					    // Calculamos el precio total del pedido
					    row.setPrecioTotal(row.getPrecioTotal() + nuevaLinea.getPrecioLinea());
					    pedidosService.add(row);
					}
					
				}
				
			}
			
		}// Agregamos una linea de pedidos a un pedido
		else {
			
			Pedidos pedido = new Pedidos();
			LineaPedidos lineaPedidos = new LineaPedidos();
			
			pedido.setUsuario(usu);
			
			Productos producto = productosService.findById(productoId);
			
			// Pedidos Setters
			pedido.setUsuario(usu);
			pedido.setEstado("Carrito");
			pedido.setFecha(Date.valueOf(LocalDate.now()));
			pedido.setPrecioTotal(precioUnitario);
			
			pedidosService.add(pedido);

			// Linea pedido Setters
			lineaPedidos.setCantidad(1);
			lineaPedidos.setProducto(producto);
			lineaPedidos.setPedido(pedido);
			lineaPedidos.setPrecioLinea(precioUnitario);
			
			lineaPedidosService.add(lineaPedidos);
			
		}
		
		return "redirect:/web#menu";
	}
}
