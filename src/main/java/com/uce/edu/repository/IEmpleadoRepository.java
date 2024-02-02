package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	// CRUD
	public Empleado seleccionar(Integer id);

	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	// Rigth Join
	public List<Empleado> seleccionarPorEmpleados();
}
