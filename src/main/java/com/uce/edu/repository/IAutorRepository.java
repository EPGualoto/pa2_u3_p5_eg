package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorRepository {
	// CRUD
	public void insertar(Autor autor);

	public Autor seleccionar(Integer id);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	// Full Join
	public List<Autor> seleccionarPorAutor();

	// Inner Join
	public List<Autor> seleccionarPorNacionalidad(String nacionalidad);

}
