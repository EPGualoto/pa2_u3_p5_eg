package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empl = this.seleccionar(id);
		this.entityManager.remove(empl);
	}

	@Override
	public List<Empleado> seleccionarPorEmpleados() {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e RIGHT JOIN e.ciudadano c", Empleado.class);
		List<Empleado> lista = myQuery.getResultList();
		for (Empleado e : lista) {
			e.getCiudadano();
		}
		return lista;
	}
}
