package com.kebab.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.repositorios.PedidosRepository;

@Service
public class PedidosServiceDB {
	
	@Autowired
	private PedidosRepository repositorio;
	
	public Pedidos add(Pedidos e) {
		return repositorio.save(e);
	}
	
	public int pedidosTotales(Usuarios usuario) {
		return repositorio.countByUsuario(usuario);
	}
	
	public List<Pedidos> pedidos(Usuarios usuario) {
		return repositorio.findByUsuario(usuario);
	}
	
	public List<Pedidos> pedidosUsuario(Usuarios usuario, String estado) {
		return repositorio.findByUsuarioAndEstadoLista(usuario, estado);
	}
	
	public List<Pedidos> todosLosPedidos() {
		return repositorio.findAll();
	}
	
	public Pedidos pedidosCarrito(Usuarios usuario, String estado) {
		return repositorio.findByUsuarioAndEstado(usuario, estado);
	}
	
	public int pedidosCarritoCount(Usuarios usuario, String estado) {
		return repositorio.countByUsuarioAndEstado(usuario, estado);
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
	public Pedidos findPedido(long id) {
		return repositorio.findById(id);
	}
	
	
}
