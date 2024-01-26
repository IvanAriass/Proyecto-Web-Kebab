package com.kebab.spring.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LineaPedidos {

	@Id @GeneratedValue
	private long id;
	private long cantidad;
	private double precioLinea;
	
	@ManyToOne
	private Pedidos pedido;
	
	@ManyToOne
	private Productos producto;

	
	public LineaPedidos() {}
	
	// Constructor
	public LineaPedidos(long id, long cantidad, double precioLinea, Pedidos pedido, Productos producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precioLinea = precioLinea;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioLinea() {
		return precioLinea;
	}

	public void setPrecioLinea(double precioLinea) {
		this.precioLinea = precioLinea;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	// Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, pedido, precioLinea, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedidos other = (LineaPedidos) obj;
		return cantidad == other.cantidad && id == other.id && Objects.equals(pedido, other.pedido)
				&& Double.doubleToLongBits(precioLinea) == Double.doubleToLongBits(other.precioLinea)
				&& Objects.equals(producto, other.producto);
	}
	
	// To string
	@Override
	public String toString() {
		return "LineaPedidos [id=" + id + ", cantidad=" + cantidad + ", precioLinea=" + precioLinea + ", pedido="
				+ pedido + ", producto=" + producto + "]";
	}


	
	
}
