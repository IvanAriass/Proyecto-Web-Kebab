package com.kebab.spring.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kebab.spring.modelo.Categorias;
import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Productos;
import com.kebab.spring.servicios.CategoriasServiceDB;
import com.kebab.spring.servicios.PedidosServiceDB;
import com.kebab.spring.servicios.ProductosServiceDB;


@Controller
public class adminControllers {

	@Autowired
	private CategoriasServiceDB categoriasService;
	
	@Autowired
	private ProductosServiceDB productosService;
	
	@Autowired
	private PedidosServiceDB pedidosService;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		
		model.addAttribute("nuevoProducto", new Productos());
		
		model.addAttribute("modificarProducto", new Productos());
		
		model.addAttribute("nuevaCategoria", new Categorias());
		
		model.addAttribute("modificarCategoria", new Categorias());
				
		List<Productos> productosAll = productosService.obtenerProductos();
		model.addAttribute("productosAll", productosAll);
		
		List<Categorias> categoriasAll = categoriasService.findAll();
		model.addAttribute("categoriasAll", categoriasAll);
		
		List<Pedidos> pedidosAll = pedidosService.todosLosPedidos();
		model.addAttribute("pedidosAll", pedidosAll);
		
		return "admin";
	}

	@PostMapping("/añadirProducto")
	public String añadirProducto(@ModelAttribute("nuevoProducto") Productos nuevoProducto) {

		productosService.add(nuevoProducto);
		
		return "redirect:/admin";
	}
	
	@PostMapping("/modificarProducto")
	public String modificaProducto(@ModelAttribute("modificarProducto") Productos modificarProducto) {
		
		Productos producto = productosService.findById(modificarProducto.getId());
		
		modificarProducto.setCategorias(producto.getCategorias());
		
		productosService.add(modificarProducto);
		
		return "redirect:/admin";
	}
	
	@PostMapping("/borrarProducto")
	public String borrarProducto(@RequestParam("productoId") long id) {
		
		productosService.delete(id);
		
		return "redirect:/admin";
		
	}
	
	@PostMapping("/añadirCategoria")
	public String añadirCategoria(@ModelAttribute("nuevaCategoria") Categorias nuevaCategoria) {
		
		categoriasService.add(nuevaCategoria);
		
		return "redirect:/admin";
	}
	
	@PostMapping("/modificarCategoria")
	public String modificarCategoria(@ModelAttribute("modificarCategoria") Categorias modificarCategoria) {
		
		Categorias categoria = categoriasService.findById(modificarCategoria.getId());
		
		modificarCategoria.setProductos(categoria.getProductos());
		
		categoriasService.add(modificarCategoria);
		
		return "redirect:/admin";
		
	}
	
	@PostMapping("/borrarCategoria")
	public String borrarCategoria(@RequestParam("categoriaId") long id) {

		categoriasService.delete(id);
		
		return "redirect:/admin";
		
	}
}
