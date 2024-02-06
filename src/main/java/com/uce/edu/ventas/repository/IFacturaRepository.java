package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public int eliminarPorNumero(String numero);

	// Consultar solo por los dos atributos
	public List<FacturaDTO> seleccionarFacturasDTO();

}
