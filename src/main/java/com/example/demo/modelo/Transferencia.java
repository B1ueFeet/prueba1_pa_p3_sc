package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_seq")
	@SequenceGenerator(name = "tran_seq", sequenceName = "tran_seq", allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;

	@Column(name = "tran_fecha")
	private LocalDateTime fecha;

	@Column(name = "tran_num_origen")
	private String numOrigen;

	@Column(name = "tran_num_destino")
	private String numDestino;

	@Column(name = "tran_monto")
	private BigDecimal monto;

	@Column(name = "tran_comision")
	private BigDecimal comision;

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", numOrigen=" + numOrigen + ", numDestino="
				+ numDestino + ", monto=" + monto + ", comision=" + comision + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumOrigen() {
		return numOrigen;
	}

	public void setNumOrigen(String numOrigen) {
		this.numOrigen = numOrigen;
	}

	public String getNumDestino() {
		return numDestino;
	}

	public void setNumDestino(String numDestino) {
		this.numDestino = numDestino;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

}
