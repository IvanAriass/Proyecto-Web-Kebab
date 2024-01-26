package com.kebab.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kebab.spring.modelo.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long>{


	
}
	