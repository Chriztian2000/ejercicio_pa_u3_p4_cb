package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.ProductoRepo;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepo productoRepo;
	

	@Override
	public void guardar(Producto producto) {
		
		List<Producto> productosExistentes = this.buscar(producto.getCodigoBarras());

		if (!productosExistentes.isEmpty()) {
			Producto productoExistente = productosExistentes.get(0);
			int nuevoStock = productoExistente.getStock() + producto.getStock();
			productoExistente.setStock(nuevoStock);
			this.modificar(productoExistente);
		} else {
			this.productoRepo.insertar(producto);
		}
		
	}

	@Override
	public List<Producto> buscar(String codigoBarras) {
		return this.productoRepo.seleccionar(codigoBarras);
		
		
		
	}

	@Override
	public void modificar(Producto producto) {
	this.productoRepo.actualizar(producto);
		
	}
	
	

}
