package com.kebab.spring.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kebab.spring.modelo.Productos;
import com.kebab.spring.repositorios.ProductosRepository;

@Service
public class ProductosServiceDB {

	@Autowired
	private ProductosRepository repositorio;
	
	public Productos add(Productos e) {
		return repositorio.save(e);
	}
	
	public List<Productos> obtenerProductos() {
		return repositorio.findAll();
    }
	
	public Productos findById(long id) {
		Optional<Productos> producto = repositorio.findById(id);
		
		if (producto.isPresent()) {
			return producto.get();
		} else {
			return null;
		}
	}
	
	public void delete(long id) {
		repositorio.deleteById(id);
	}
	
}
