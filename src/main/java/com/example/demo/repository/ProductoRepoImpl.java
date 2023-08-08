package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepoImpl implements ProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
	
		this.entityManager.persist(producto);
	}

	@Override
	public List<Producto> seleccionar(String codigoBarras) {
		Query myQuery = this.entityManager.createQuery("SELECT cod FROM Producto cod WHERE cod.codigoBarras = :datoCodigoBarras");
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		return myQuery.getResultList();	
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
		
	}

	

	
}
