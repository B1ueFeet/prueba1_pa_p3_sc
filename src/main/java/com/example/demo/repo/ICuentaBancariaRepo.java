package com.example.demo.repo;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	//CRUD
	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscar(String numero);
	public void eliminar(String numero);
}
