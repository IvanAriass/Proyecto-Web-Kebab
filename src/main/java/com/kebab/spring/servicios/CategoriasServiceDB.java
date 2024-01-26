package com.kebab.spring.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kebab.spring.modelo.Categorias;
import com.kebab.spring.modelo.Productos;
import com.kebab.spring.repositorios.CategoriasRepository;

@Service
public class CategoriasServiceDB {

	@Autowired
	public CategoriasRepository repositorio;
	
	public Categorias add(Categorias e) {
		return repositorio.save(e);
	}
	
	public Categorias obtenerPrimeraId() {
		return repositorio.primeraCategoria();
	}
	
	public List<Categorias> findAll() {
		return repositorio.findAll();
	}
	
	public Categorias findById(long id) {
		
		Optional<Categorias> categoria = repositorio.findById(id);
		
		if (categoria.isPresent()) {
			return categoria.get();
		} else {
			return null;
		}
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
}
