package com.kebab.spring.modelo;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedidos {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private double precioTotal;
	
	@Column(nullable=false)
	private Date fecha;
	
	@ManyToOne
	private Usuarios usuario;
	
	@OneToMany(mappedBy="pedido")
	private List<LineaPedidos> lineaPedidos;
	
	private String estado;

	
	// Constructor

	
	public Pedidos() { }

	public Pedidos(long id, double precioTotal, Date fecha, Usuarios usuario, List<LineaPedidos> lineaPedidos,
			String estado) {
		super();
		this.id = id;
		this.precioTotal = precioTotal;
		this.fecha = fecha;
		this.usuario = usuario;
		this.lineaPedidos = lineaPedidos;
		this.estado = estado;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<LineaPedidos> getLineaPedidos() {
		return lineaPedidos;
	}

	public void setLineaPedidos(List<LineaPedidos> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	//Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(estado, fecha, id, lineaPedidos, precioTotal, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(fecha, other.fecha) && id == other.id
				&& Objects.equals(lineaPedidos, other.lineaPedidos)
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal)
				&& Objects.equals(usuario, other.usuario);
	}

	
	// To String
	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", precioTotal=" + precioTotal + ", fecha=" + fecha + ", usuario=" + usuario
				+ ", lineaPedidos=" + lineaPedidos + ", estado=" + estado + "]";
	}
	


	
	
	
	
	
	
}
