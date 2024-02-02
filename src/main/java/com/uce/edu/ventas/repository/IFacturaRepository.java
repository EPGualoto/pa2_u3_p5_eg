package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);

	public int eliminarPorNumero(String numero);

	public List<Factura> seleccionarFacturasInnerJoin();

	public List<Factura> seleccionarFacturasRigthJoin();

	public List<Factura> seleccionarFacturasLeftJoin();

	public List<Factura> seleccionarFacturasFullJoin();

	public List<Factura> seleccionarFacturasWhereJoin();

	public List<Factura> seleccionarFacturasFetchJoin();

	// Consultar solo por los dos atributos
	public List<FacturaDTO> seleccionarFacturasDTO();

	// Full Join
	public List<Factura> seleccionarPorNumeroF(String numero);
}
