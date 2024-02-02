package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {

	public Empleado buscar(Integer id);

	public void guardar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	// Rigth Join
	public List<Empleado> buscarPorEmpleados();
}
