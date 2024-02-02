package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hote = this.seleccionar(id);
		this.entityManager.remove(hote);
	}

	@Override
	public List<Hotel> seleccionarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE h.direccion= :direccion", Hotel.class);
		myQuery.setParameter("direccion", direccion);
		List<Hotel> hoteles = myQuery.getResultList();
		return hoteles;
	}

	@Override
	public List<Hotel> seleccionarPorHoteles() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> mYQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha",
				Hotel.class);

		return mYQuery.getResultList();
	}

}
