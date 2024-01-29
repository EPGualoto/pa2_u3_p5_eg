package com.uce.edu.reservas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.reservas.repository.modelo.Habitacion;
import com.uce.edu.reservas.repository.modelo.Hotel;

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
	public List<Habitacion> seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = entityManager
				.createQuery("SELECT h FROM Habitacion h RIGHT JOIN h.hotel ho WHERE ho.id = :id", Habitacion.class);
		myQuery.setParameter("id", id);
		List<Habitacion> habitaciones = myQuery.getResultList();
		for (Habitacion habitacion : habitaciones) {
			habitacion.getHotel().getHabitaciones().size();
		}

		return habitaciones;
	}

	@Override
	public List<Hotel> seleccionarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = entityManager.createQuery(
				"SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE h.direccion= :direccion", Hotel.class);
		myQuery.setParameter("direccion", direccion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}
	
	@Override
	public List<Hotel> seleccionarPorClase(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.clase= :clase", Hotel.class);
		myQuery.setParameter("clase", clase);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}

	@Override
	public List<Habitacion> seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = entityManager
				.createQuery("SELECT h FROM Habitacion h FULL JOIN h.hotel ho WHERE h.numero = :numero", Habitacion.class);
		myQuery.setParameter("numero", numero);
		List<Habitacion> habitaciones = myQuery.getResultList();
		for (Habitacion habitacion : habitaciones) {
			habitacion.getHotel().getHabitaciones().size();
		}
		return habitaciones;
	}
	
}
