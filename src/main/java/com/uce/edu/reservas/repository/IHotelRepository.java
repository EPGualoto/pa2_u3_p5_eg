package com.uce.edu.reservas.repository;

import java.util.List;

import com.uce.edu.reservas.repository.modelo.Habitacion;
import com.uce.edu.reservas.repository.modelo.Hotel;

public interface IHotelRepository {
	// CRUD
	public void insertar(Hotel hotel);

	public Hotel seleccionar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	// Inner Join
	public List<Hotel> seleccionarPorDireccion(String direccion);

	// Right Join
	public List<Habitacion> seleccionarPorId(Integer id);
	
	// Left Join
	public List<Hotel> seleccionarPorClase(String clase);

	// Full Join
	public List<Habitacion> seleccionarPorNumero(String numero);

}
