package com.example.demo.correccion.repo;

import com.example.demo.correccion.modelo.Cuenta;

public interface ICuentaRepo {

	// CRUD
	public void insertar(Cuenta cuenta);

	public void actualizar(Cuenta cuenta);

	public Cuenta buscar(String numero);

	public void eliminar(String numero);

}
