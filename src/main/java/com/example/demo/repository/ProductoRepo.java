package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoRepo {
	
	public void insertar(Producto producto);
	public List<Producto> seleccionar (String codigoBarras);
	public void actualizar (Producto producto);
}
