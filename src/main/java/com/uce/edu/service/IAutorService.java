package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	// CRUD
	public void guardar(Autor autor);

	public Autor buscar(Integer id);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	// Full Join
	public List<Autor> buscarPorAutor();

	// Inner Join
	public List<Autor> buscarPorNacionalidad(String nacionalidad);
}
