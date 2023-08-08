package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRespoImpl implements FacturaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public void insertar(Factura factura) {		
		this.entityManager.persist(factura);		
	}	

}
