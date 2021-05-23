package com.example.demo.models.item;

public class Item {

	private Producto producto;
	
	private Integer cantidad;

	public Item() {}
	
	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {
		return this.cantidad.doubleValue() * this.producto.getPrecio();
	}
	
}
