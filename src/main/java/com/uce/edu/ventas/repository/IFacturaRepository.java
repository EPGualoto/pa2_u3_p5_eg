package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public int eliminarPorNumero(String numero);

	public List<Factura> seleccionarTodos();

}
