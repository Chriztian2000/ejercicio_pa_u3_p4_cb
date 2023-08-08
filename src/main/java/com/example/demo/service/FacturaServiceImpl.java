package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FacturaRepo;
import com.example.demo.repository.modelo.Factura;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepo facturaRepo;

	@Override
	public void guardar(Factura factura) {
		
		this.facturaRepo.insertar(factura);
		
	}
	
	

}
