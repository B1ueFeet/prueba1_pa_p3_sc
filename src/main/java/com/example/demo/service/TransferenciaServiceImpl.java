package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.repo.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo transferenciaRepo;

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	@Override
	public void realizar(String origen, String destino, BigDecimal monto) {

		CuentaBancaria cuentaOrigen = this.cuentaBancariaService.buscar(origen);
		CuentaBancaria cuentaDestino = this.cuentaBancariaService.buscar(destino);
		
		System.out.println("\n" + cuentaOrigen.toString()+"\n");
		System.out.println("\n" + cuentaDestino.toString()+"\n");

		if (cuentaDestino == null || cuentaOrigen == null) {
			System.err.println("\nLA TRANSACCION NO PUDO SER REALIZADA\nRevise las cuentas e intente de nuevo\n");
		}else if (cuentaOrigen.getSaldo().compareTo(monto) >= 0) {
			// transaccion
			BigDecimal comision = monto.multiply(new BigDecimal(0.05));
			BigDecimal auxiliar = cuentaOrigen.getSaldo().subtract(comision);
			auxiliar= auxiliar.subtract(monto);
			cuentaOrigen.setSaldo(auxiliar);
			this.cuentaBancariaService.modificar(cuentaOrigen);

			auxiliar = cuentaDestino.getSaldo().add(monto);

			cuentaDestino.setSaldo(auxiliar);
			this.cuentaBancariaService.modificar(cuentaDestino);
			
			//transferencia 
			Transferencia transferencia = new Transferencia();
			transferencia.setComision(comision);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumDestino(destino);
			transferencia.setNumOrigen(origen);
			
			this.transferenciaRepo.insertar(transferencia);
			
			System.err.println("\nLA TRANSFERENCIA SE REALIZO CON EXITO\n");

		} else {

			System.err.println("\nLA TRANSACCION NO PUDO SER REALIZADA\nRevise el monto e intente de nuevo\n");

		}

	}

}
