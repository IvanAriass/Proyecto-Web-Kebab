package com.kebab.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kebab.spring.modelo.LineaPedidos;
import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.repositorios.LineaPedidosRepository;

@Service
public class LineaPedidosDB {

		@Autowired
		public LineaPedidosRepository repositorio;
		
		public List<LineaPedidos> lineaPedidos (Pedidos pedido) {
			return repositorio.findByPedido(pedido);
		}
		
		public LineaPedidos add(LineaPedidos e) {
			return repositorio.save(e);
		}
		
		public void delete(long id) {
			repositorio.deleteById(id);
		}
		
		public int count(Pedidos pedido) {
			return repositorio.countByPedido(pedido);
		}
		
		public void deletePedido(Pedidos pedido) {
			repositorio.deleteByPedido(pedido);
		}
				
		
		
	
}
