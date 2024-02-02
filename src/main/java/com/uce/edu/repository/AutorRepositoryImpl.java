package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor autor = this.seleccionar(id);
		this.entityManager.remove(autor);
	}

	@Override
	public List<Autor> seleccionarPorAutor() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager.createQuery("SELECT a FROM Autor a FULL JOIN a.libros l",
				Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = entityManager.createQuery(
				"SELECT a FROM Autor a INNER JOIN a.libros l WHERE a.nacionalidad= :nacionalidad", Autor.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		List<Autor> autores = myQuery.getResultList();
		for (Autor a : autores) {
			a.getLibros().size();
		}
		return autores;
	}
}
