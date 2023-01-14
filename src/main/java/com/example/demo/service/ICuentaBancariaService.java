package com.example.demo.service;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	//CRUD
	public void crear(CuentaBancaria cuentaBancaria);
	public void modificar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscar(String numero);
	public void remover(String numero);

}
