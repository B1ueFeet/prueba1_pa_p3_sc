package com.example.demo.repo;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	//CRUD
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia buscar(Integer id);
	public void eliminar(Integer id);

}
