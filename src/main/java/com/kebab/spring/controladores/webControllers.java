package com.kebab.spring.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kebab.spring.modelo.Categorias;
import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.servicios.CategoriasServiceDB;
import com.kebab.spring.servicios.PedidosServiceDB;
import com.kebab.spring.servicios.UsuariosServiceDB;

import jakarta.validation.Valid;

@Controller
public class webControllers {
	
	@Autowired
	private UsuariosServiceDB usuariosService;
	
	@Autowired
	private CategoriasServiceDB categoriasService;
	
	@Autowired
	private PedidosServiceDB pedidosService;
	
	@GetMapping({"/","/login"})
	public String nuevoUsuarioSubmit(Model model) {
		model.addAttribute("usuariosForm", new Usuarios());
		return "login";
	}
	
	@GetMapping("/web")
	public String web(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getName();
		
		Usuarios usu = usuariosService.findFirstByEmail(email);
		model.addAttribute("usuario", usu);
		
		List<Categorias> categorias = categoriasService.findAll();
		model.addAttribute("categorias", categorias);
		
		List<Pedidos> pedidosAll = pedidosService.pedidosUsuario(usu, "Realizado");
		model.addAttribute("pedidosAll", pedidosAll);
		
		Categorias primeraCategoria = categoriasService.obtenerPrimeraId();
		model.addAttribute("primeraCategoria", primeraCategoria);
		
		Date fechaActual = new Date();
		model.addAttribute("fechaActual", fechaActual);
		
		int pedidosCount = pedidosService.pedidosCarritoCount(usu, "Carrito");
		model.addAttribute("pedidosCount", pedidosCount);
		
		int pedidosTotalesUsu = pedidosService.pedidosTotales(usu);
		model.addAttribute("pedidosTotales", pedidosTotalesUsu);
				
		if (pedidosCount > 0) {
			Pedidos pedido = pedidosService.pedidosCarrito(usu, "Carrito");
			model.addAttribute("pedidosCarrito", pedido);
		}
		
		return "web";
	}
	
	@PostMapping("/registro")
	public String nuevoUsuarioSubmit(@Valid @ModelAttribute ("usuariosForm") Usuarios nuevoUsuario, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return "login";
		} else {
			usuariosService.add(nuevoUsuario);
			return "redirect:/web";
		}
	}

}
