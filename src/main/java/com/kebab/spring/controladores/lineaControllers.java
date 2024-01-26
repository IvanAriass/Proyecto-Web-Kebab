package com.kebab.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.servicios.PedidosServiceDB;

@Controller
public class lineaControllers {
	
	
	@Autowired
	private PedidosServiceDB pedidosService;
	
	@PostMapping("/lineapedido")
	public String lineaPedido(@RequestParam("pedidoId") long id, Model model) {
		
		Pedidos pedido = pedidosService.findPedido(id);
		model.addAttribute("pedido", pedido);
		
		return "/lineapedido";
	}

}
