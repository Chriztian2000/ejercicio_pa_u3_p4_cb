package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@SequenceGenerator(name = "seq_prod", sequenceName = "seq_prod", allocationSize = 1)
	@GeneratedValue(generator = "seq_prod", strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	private Integer id;
	
	@Column(name = "prod_codigobarras")
	private String codigoBarras;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_categoria")
	private String categoria;
	
	@Column(name = "prod_stock")
	private Integer stock;
	
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
	private List<DetalleFactura> detalleFacturas;

	
	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", categoria="
				+ categoria + ", stock=" + stock + ", precio=" + precio + "]";
	}

	

	
	
	
	
	
	
}
