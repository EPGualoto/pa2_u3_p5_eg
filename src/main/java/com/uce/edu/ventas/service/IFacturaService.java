package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura, Cliente cliente);

	public int borrarPorNumero(String numero);

	public void borrar(Integer id);

	public List<Factura> buscarFacturas();

	public void prueba();

	public void pruebaSupport();

	// public void pruebaSupport2();

	public void pruebaNever();

}
