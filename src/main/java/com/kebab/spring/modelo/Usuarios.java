package com.kebab.spring.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuarios {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellidos;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String contraseña;
	
	@Column(nullable=false)
	private String rol;
	
	@Column(nullable=false, unique=true)
	private String dni;
	
	@Column(nullable=false)
	private String direccion;
	
	@Column(nullable=false)
	private String telefono;

	
	public Usuarios() {}
	
	// Constructor
	public Usuarios(String nombre, String apellidos, String email, String contraseña, String rol, String dni,
			String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.rol = rol;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	// Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, contraseña, direccion, dni, email, id, nombre, rol, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(contraseña, other.contraseña)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(rol, other.rol) && Objects.equals(telefono, other.telefono);
	}
	
	// To String
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", contraseña=" + contraseña + ", rol=" + rol + ", dni=" + dni + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	
}
