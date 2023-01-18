package com.example.demo.correccion.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.correccion.modelo.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CuentaRepoImpl implements ICuentaRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.manager.persist(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.manager.merge(cuenta);
	}

	@Override
	public Cuenta buscar(String numero) {
		// TODO Auto-generated method stub
		return this.manager.find(Cuenta.class, numero);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.manager.remove(this.buscar(numero));
	}

}
