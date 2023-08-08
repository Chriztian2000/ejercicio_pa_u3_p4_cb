package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoService {
	
	public void guardar(Producto producto);
	public List<Producto> buscar (String codigoBarras);
	public void modificar (Producto producto);

}
