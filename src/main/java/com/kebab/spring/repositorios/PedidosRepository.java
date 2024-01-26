package com.kebab.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kebab.spring.modelo.Pedidos;
import com.kebab.spring.modelo.Usuarios;

public interface PedidosRepository extends JpaRepository<Pedidos, Long>{
	
	int countByUsuario(Usuarios usuario);
		
	@Query("SELECT p FROM Pedidos p WHERE p.usuario = :usuario")
    List<Pedidos> findByUsuario(@Param("usuario") Usuarios usuario);
	
	Pedidos findByUsuarioAndEstado(Usuarios usuario, String estado);
	
	@Query("SELECT p FROM Pedidos p WHERE p.usuario = :usuario AND p.estado = :estado")
    List<Pedidos> findByUsuarioAndEstadoLista(@Param("usuario") Usuarios usuario, @Param("estado") String estado);
	
	int countByUsuarioAndEstado(Usuarios usuario, String estado);
	
	Pedidos findById(long id);
}
