package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura);

	public List<Factura> buscarFacturasInnerJoin();

	public List<Factura> buscarFacturasRigthJoin();

	public List<Factura> buscarFacturasLeftJoin();

	public List<Factura> buscarFacturasFullJoin();

	public List<Factura> buscarFacturasWhereJoin();

	public List<Factura> buscarFacturasFetchJoin();
	
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public int borrarPorNumero(String numero);
	
	public void borrar(Integer id);
	
	public List<FacturaDTO> buscarFacturasDTO();
	
	// Full Join
	public List<Factura> buscarPorNumeroF(String numero);

}
