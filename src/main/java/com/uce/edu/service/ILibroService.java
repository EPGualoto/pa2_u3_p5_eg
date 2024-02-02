package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroService {
	// CRUD
	public void guardar(Libro libro);

	public Libro buscar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	// Inner Join
	public List<Libro> buscarPorLibros();
	
	// Right Join
	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);
}
