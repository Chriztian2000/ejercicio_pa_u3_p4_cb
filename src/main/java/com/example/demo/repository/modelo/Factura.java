package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "factura")
public class Factura {
	
	@Id
	@SequenceGenerator(name = "seq_fac", sequenceName = "seq_fac", allocationSize = 1)
	@GeneratedValue(generator = "seq_fac", strategy = GenerationType.SEQUENCE)
	@Column(name = "fac_id")
	private Integer id;
	
	@Column(name = "fac_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fac_cedulaCliente")
	private String cedulaCliente;
	
	@Column(name = "fac_totalFactura")
	private BigDecimal totalFactura;
		
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
	private List<DetalleFactura> detalleFacturas;
	
	//GET Y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente + ", totalFactura="
				+ totalFactura + "]";
	}	
	
}
