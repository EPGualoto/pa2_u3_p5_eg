package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
	// Tambien funciona con Autowired
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciud = this.seleccionar(id);
		this.entityManager.remove(ciud);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public List<Ciudadano> seleccionarPorCiudadano() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c LEFT JOIN c.empleado e", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = entityManager.createQuery(
				"SELECT c FROM Ciudadano c LEFT JOIN c.empleado e WHERE c.cedula= :cedula", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		List<Ciudadano> ciudadanos = myQuery.getResultList();
		for (Ciudadano c : ciudadanos) {
			c.getEmpleado();
		}
		return ciudadanos;
	}
}
