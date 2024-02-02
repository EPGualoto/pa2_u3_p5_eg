package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {

	public Ciudadano buscar(Integer id);

	public void guardar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	// Left Join
	public List<Ciudadano> buscarPorCiudadano();
	
	public List<Ciudadano> buscarPorCedula(String cedula);

}
