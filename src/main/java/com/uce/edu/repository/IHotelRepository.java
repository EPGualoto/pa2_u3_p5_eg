package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	// CRUD
	public void insertar(Hotel hotel);

	public Hotel seleccionar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	// Fetch Join
	public List<Hotel> seleccionarPorHoteles();

	public List<Hotel> seleccionarPorDireccion(String direccion);

}
