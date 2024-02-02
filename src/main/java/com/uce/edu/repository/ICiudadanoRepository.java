package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
	// CRUD
	public Ciudadano seleccionar(Integer id);

	public void insertar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	// Left Join
	public List<Ciudadano> seleccionarPorCiudadano();

	public List<Ciudadano> seleccionarPorCedula(String cedula);

}
