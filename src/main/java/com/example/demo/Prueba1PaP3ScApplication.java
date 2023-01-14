package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3ScApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3ScApplication.class, args);
		
		
	}
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//PARTE 1: CUENTAS BANCARIAS
		
//		CuentaBancaria bancaria1 = new  CuentaBancaria();
//		bancaria1.setCedulaP("1717560930");
//		bancaria1.setNumero("2203103465");
//		bancaria1.setSaldo(new BigDecimal(3000));
//		bancaria1.setTipo("C"); // C = CORRIENTE | A = AHORRO
//		this.cuentaBancariaService.crear(bancaria1);
		
//		CuentaBancaria bancaria2 = new  CuentaBancaria();
//		bancaria2.setCedulaP("1717844466");
//		bancaria2.setNumero("2122456783");
//		bancaria2.setSaldo(new BigDecimal(7000));
//		bancaria2.setTipo("A"); // C = CORRIENTE | A = AHORRO
//		this.cuentaBancariaService.crear(bancaria2);
		
		//PARTE 2: TRANSFERENCIA
		
		this.transferenciaService.realizar("2122456783", "2203103465", new BigDecimal(100));
		
		
		
		
		
		
	}

}
