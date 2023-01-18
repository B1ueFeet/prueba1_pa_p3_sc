package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.service.ICuentaService;
import com.example.demo.correccion.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3ScApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3ScApplication.class, args);

	}

	@Autowired
	private ICuentaService cuentaService;
	@Autowired
	private ITransferenciaService transferenciaService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// PARTE 1: CUENTAS BANCARIAS

		Cuenta bancaria1 = new Cuenta();
		bancaria1.setCedulaP("171756093");
		bancaria1.setNumero("2203103461");
		bancaria1.setSaldo(new BigDecimal(3000));
		bancaria1.setTipo("C"); // C = CORRIENTE | A = AHORRO
		this.cuentaService.guardar(bancaria1);

		Cuenta bancaria2 = new Cuenta();
		bancaria2.setCedulaP("1717844466");
		bancaria2.setNumero("2122456781");
		bancaria2.setSaldo(new BigDecimal(7000));
		bancaria2.setTipo("A"); // C = CORRIENTE | A = AHORRO
		this.cuentaService.guardar(bancaria2);

		
		// PARTE 2: TRANSFERENCIA

		this.transferenciaService.realizar("2122456781", "2203103461", new BigDecimal(100));
		
		System.err.println("Saldo Cuenta Origen: "+this.cuentaService.encontrar("2122456781").getSaldo());
	}

}
