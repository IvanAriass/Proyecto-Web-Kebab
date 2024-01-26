package com.kebab.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kebab.spring.modelo.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	
	
	// Ver la primera categoria
	@Query("SELECT c FROM Categorias c ORDER BY c.id LIMIT 1")
	Categorias primeraCategoria();
	
}
