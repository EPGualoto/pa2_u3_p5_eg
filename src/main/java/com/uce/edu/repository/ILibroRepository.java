package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroRepository {
	// CRUD
	public void insertar(Libro libro);

	public Libro seleccionar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	// Inner Join
	public List<Libro> seleccionarPorLibros();

	// Right Join
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);

}
