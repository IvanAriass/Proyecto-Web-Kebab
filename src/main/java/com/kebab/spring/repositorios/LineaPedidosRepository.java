package com.kebab.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kebab.spring.modelo.LineaPedidos;
import com.kebab.spring.modelo.Pedidos;

public interface LineaPedidosRepository extends JpaRepository<LineaPedidos, Long>{

	
	List<LineaPedidos> findByPedido(Pedidos pedido);
	
	int countByPedido (Pedidos pedido);
	
	void deleteByPedido(Pedidos pedido);
	
}
