package com.uce.edu.reservas.service;

import java.util.List;

import com.uce.edu.reservas.repository.modelo.Habitacion;
import com.uce.edu.reservas.repository.modelo.Hotel;

public interface IHotelService {
	// CRUD
	public void guardar(Hotel hotel);

	public Hotel buscar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	// Inner Join
	public List<Hotel> buscarPorDireccion(String direccion);

	// Right Join
	public List<Habitacion> buscarPorId(Integer id);

	// Left Join
	public List<Hotel> buscarPorClase(String clase);

	// Full Join
	public List<Habitacion> buscarPorNumero(String numero);

}
