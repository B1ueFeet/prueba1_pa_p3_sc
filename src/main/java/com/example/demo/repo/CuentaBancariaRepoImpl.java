package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.manager.persist(cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.manager.merge(cuentaBancaria);

	}

	@Override
	public CuentaBancaria buscar(String numero) {
		
		return this.manager.find(CuentaBancaria.class, numero);
	}

	@Override
	public void eliminar(String numero) {
		this.manager.remove(numero);
	}

}
