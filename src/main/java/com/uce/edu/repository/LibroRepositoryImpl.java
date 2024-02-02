package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro libro = this.seleccionar(id);
		this.entityManager.remove(libro);
	}

	@Override
	public List<Libro> seleccionarPorLibros() {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l INNER JOIN l.autores a",
				Libro.class);
		List<Libro> lista = myQuery.getResultList();
		for (Libro l : lista) {
			l.getAutores().size(); // señal
		}
		return lista;
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = entityManager.createQuery(
				"SELECT l FROM Libro l RIGHT JOIN l.autores a WHERE l.fechaPublicacion >= :fechaPublicacion",
				Libro.class);
		myQuery.setParameter("fechaPublicacion", fechaPublicacion);
		List<Libro> libros = myQuery.getResultList();
		for (Libro l : libros) {
			l.getAutores().size();
		}
		return libros;
	}
}
