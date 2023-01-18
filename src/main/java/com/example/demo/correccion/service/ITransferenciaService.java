package com.example.demo.correccion.service;

import java.math.BigDecimal;

public interface ITransferenciaService {
	
	public void realizar (String numOrigen, String numDestino, BigDecimal monto);

}
