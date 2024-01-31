package com.uce.edu.ventas.repository.modelo.dto;

import java.time.LocalDateTime;

//Data Transfer Object
public class FacturaDTO {
	private String numero;
	private LocalDateTime fecha;
	
	@Override
	public String toString() {
		return "FacturaDTO [numero=" + numero + ", fecha=" + fecha + "]";
	}

	//Siempre se debe crear el constructor por defecto
	public FacturaDTO() {
		
	}
	
	//Generate constructor using fields
	public FacturaDTO(String numero, LocalDateTime fecha) {
		super(); //Ejecuta el constructor del padre
		this.numero = numero;
		this.fecha = fecha;
	}

	// SET Y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
