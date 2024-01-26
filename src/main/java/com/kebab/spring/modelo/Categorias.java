package com.kebab.spring.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categorias {
	
	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Productos> productos;

	// Constructor
	public Categorias(long id, String nombre, List<Productos> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = productos;
	}
	
	
	// Constructor categorias
	public Categorias(String nombre) {
		super();
		this.nombre = nombre;
	}

	// Constructor default
	public Categorias() {}

	
	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Productos> getProductos() {
		return productos;
	}


	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	// Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, productos);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorias other = (Categorias) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(productos, other.productos);
	}

	// To string
	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
	}
	
}
