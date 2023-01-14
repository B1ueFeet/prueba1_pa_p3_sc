package com.example.demo.repo;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Transferencia transferencia) {
		this.manager.persist(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.manager.merge(transferencia);

	}

	@Override
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.manager.find(Transferencia.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.manager.remove(id);

	}

}
