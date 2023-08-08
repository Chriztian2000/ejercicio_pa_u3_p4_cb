package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ProductoService;

@SpringBootApplication
public class EjercicioPaU3P4CbApplication implements CommandLineRunner {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private FacturaService facturaService;

	private static final Logger LOG = LoggerFactory.getLogger(EjercicioPaU3P4CbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4CbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//1
		Producto pro= new Producto();
		pro.setCodigoBarras("123456789");
		pro.setNombre("Paracetamol");
		pro.setCategoria("Analgesico");
		pro.setStock(100);
		pro.setPrecio(new BigDecimal(0.10));		
		this.productoService.guardar(pro);
		
		Producto pro2= new Producto();
		pro2.setCodigoBarras("123456789");
		pro2.setNombre("Paracetamol");
		pro2.setCategoria("Analgesico");
		pro2.setStock(100);
		pro2.setPrecio(new BigDecimal(0.10));		
		this.productoService.guardar(pro2);
		
		Producto pro3= new Producto();
		pro3.setCodigoBarras("987654321");
		pro3.setNombre("Ibuprofeno");
		pro3.setCategoria("Antinflamatorio");
		pro3.setStock(40);
		pro3.setPrecio(new BigDecimal(0.25));		
		this.productoService.guardar(pro3);
		
		Producto pro4= new Producto();
		pro4.setCodigoBarras("987654321");
		pro4.setNombre("Ibuprofeno");
		pro4.setCategoria("Antinflamatorio");
		pro4.setStock(10);
		pro4.setPrecio(new BigDecimal(0.25));		
		this.productoService.guardar(pro4);
		
		
		
		//2
		
		Producto prodet = new Producto();
		prodet.setCodigoBarras("111111111111");
		prodet.setNombre("Ibuprofeno");
		prodet.setCategoria("Antinflamatorio");
		prodet.setStock(10);
		prodet.setPrecio(new BigDecimal(0.25));
	
		
		DetalleFactura deta=new DetalleFactura();
		deta.setCantidad(10);
		deta.setPrecioUnitario(prodet.getPrecio());
		deta.setProducto(prodet);
				
		Factura fact= new Factura();
		fact.setFecha(LocalDateTime.now());
		fact.setCedulaCliente("1722781000");
		//fact.setDetalleFacturasdeta);		
		this.facturaService.guardar(fact);
			
		
	}

}
