package com.kebab.spring.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kebab.spring.modelo.LineaPedidos;
import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.servicios.LineaPedidosDB;
import com.kebab.spring.servicios.PedidosServiceDB;
import com.kebab.spring.servicios.UsuariosServiceDB;

@Controller
public class vistaCestaControllers {
	
	@Autowired
	private UsuariosServiceDB usuariosService;
	
	@Autowired
	private PedidosServiceDB pedidosService;
	
	@Autowired 
	private LineaPedidosDB lineaPedidosService;
	
	@PostMapping("/borrarLinea")
	public String borrarLinea(@RequestParam("lineaId") long lineaId, @RequestParam("precioLinea") double precioLinea, @RequestParam("pedidoId") long pedidoId) {
		
		// Borramos la linea del pedido
		lineaPedidosService.delete(lineaId);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		
		Usuarios usu = usuariosService.findFirstByEmail(email);
		
		Pedidos pedidoLinea = pedidosService.findPedido(pedidoId);
				
		// Eliminar linea del pedido en caso de que existan lineas en el pedido
		if (lineaPedidosService.count(pedidoLinea) > 0) {
			Pedidos pedido = pedidosService.pedidosCarrito(usu, "Carrito");
			pedido.setPrecioTotal(pedido.getPrecioTotal() - precioLinea);
			pedidosService.add(pedido);
		} 
		// Eliminar el pedido en caso de que no existán más lineas en el pedido
		else {
			
			pedidosService.delete(pedidoId);
			
		}
		
		return "redirect:/web#menu";
	}
	
	
	@PostMapping("/realizarPedido")
	public String realizarPedido(@RequestParam String action, @RequestParam("pedidoId") long pedidoId) {
		
		if ("realizarPedido".equals(action)) {
			
			Pedidos pedido = pedidosService.findPedido(pedidoId);
			
			pedido.setEstado("Realizado");
			
			pedidosService.add(pedido);
			
		} else if ("cancelarPedido".equals(action)) {
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			String email = authentication.getName();
			Usuarios usu = usuariosService.findFirstByEmail(email);
			
			Pedidos pedido = pedidosService.findPedido(pedidoId);
			
			List<Pedidos> pedidos = pedidosService.pedidos(usu);
			
			for (Pedidos row : pedidos) {
				
				if("Carrito".equals(row.getEstado())) {
					
					for (LineaPedidos linea : row.getLineaPedidos()) {
						
						if (linea.getPedido() == pedido) {
							
							lineaPedidosService.delete(linea.getId());
							
						}
					}
					
				}
			}
			
			pedidosService.delete(pedidoId);
			
		}
		
		return "redirect:/web#menu";
	}
}
