package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
	@Column(name = "cuen_tipo")
	private String tipo;

	@Id
	@Column(name = "cuen_numero")
	private String numero;
	
	@Column(name = "cuen_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cuen_cedula")
	private String cedulaP;

	@Override
	public String toString() {
		return "CuentaBancaria [tipo=" + tipo + ", numero=" + numero + ", saldo=" + saldo + ", cedulaP=" + cedulaP
				+ "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getCedulaP() {
		return cedulaP;
	}

	public void setCedulaP(String cedulaP) {
		this.cedulaP = cedulaP;
	}

	
	
}
