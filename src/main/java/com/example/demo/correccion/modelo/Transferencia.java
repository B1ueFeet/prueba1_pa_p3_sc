package com.example.demo.correccion.modelo;

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
	private String numeroOrigen;

	@Column(name = "tran_num_destino")
	private String numeroDestino;

	@Column(name = "tran_monto")
	private BigDecimal monto;

	@Column(name = "tran_comision")
	private BigDecimal comision;

	// TO STRING
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", numeroOrigen=" + numeroOrigen + ", numeroDestino="
				+ numeroDestino + ", monto=" + monto + ", comision=" + comision + "]";
	}

	// GETTER & SETTER

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

	public String getNumeroOrigen() {
		return numeroOrigen;
	}

	public void setNumeroOrigen(String numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}

	public String getNumeroDestino() {
		return numeroDestino;
	}

	public void setNumeroDestino(String numeroDestino) {
		this.numeroDestino = numeroDestino;
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
