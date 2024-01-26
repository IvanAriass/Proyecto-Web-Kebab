package com.kebab.spring.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Productos {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nombre;
	private String descripcion;
	
	@Column(nullable=false)
	private double precioUnitario;
	private String imagen;
	
	@ManyToMany
	@JoinTable (
			name="ProductosCategorias",
			joinColumns = @JoinColumn(name = "productos_id"),
			inverseJoinColumns = @JoinColumn(name = "categorias_id")
			
	)
	private List<Categorias> categorias;
	
	public Productos() {}
	

	// Constructor
	public Productos(String nombre, String descripcion, double precioUnitario, String imagen,
			List<Categorias> categorias) {;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.imagen = imagen;
		this.categorias = categorias;
	}
	
	

	// Constructor productos
	public Productos(String nombre, String descripcion, double precioUnitario, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.imagen = imagen;
	}




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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public List<Categorias> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categorias> categorias) {
		this.categorias = categorias;
	}

	// Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(categorias, descripcion, id, imagen, nombre, precioUnitario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return Objects.equals(categorias, other.categorias) && Objects.equals(descripcion, other.descripcion)
				&& id == other.id && Objects.equals(imagen, other.imagen) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precioUnitario) == Double.doubleToLongBits(other.precioUnitario);
	}

	
	// To string
	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", imagen=" + imagen + "]";
	}

	
	
}
