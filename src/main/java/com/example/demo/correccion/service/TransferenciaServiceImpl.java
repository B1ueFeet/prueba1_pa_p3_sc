
package com.example.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.modelo.Transferencia;
import com.example.demo.correccion.repo.ICuentaRepo;
import com.example.demo.correccion.repo.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaRepo cuentaRepo;

	@Autowired
	private ITransferenciaRepo transferenciaRepo;

	@Override
	public void realizar(String numOrigen, String numDestino, BigDecimal monto) {

		// BUSQUEDA
		Cuenta origen = this.cuentaRepo.buscar(numOrigen);
		Cuenta destino = this.cuentaRepo.buscar(numDestino);

		// MONTO A DEBITAR
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoDebitar = monto.add(comision);

		// COMPARE TO RETORNA
		// 0 IGUALES | -1 MENOR | 1 MAYOR
		if (origen.getSaldo().compareTo(montoDebitar) <= 0) {
			System.err.println("Monto no permitido");
		} else {
			// TRANSFERENCIA
			Transferencia transferencia = new Transferencia();
			transferencia.setComision(comision);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumeroDestino(numDestino);
			transferencia.setNumeroOrigen(numOrigen);
			this.transferenciaRepo.insertar(transferencia);
			// DEBITAR
			origen.setSaldo(origen.getSaldo().subtract(montoDebitar));
			this.cuentaRepo.actualizar(origen);
			// DESTINO
			destino.setSaldo(destino.getSaldo().add(monto));
			this.cuentaRepo.actualizar(destino);
		}

	}

}
