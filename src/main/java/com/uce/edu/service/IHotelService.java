package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {
	// CRUD
	public void guardar(Hotel hotel);

	public Hotel buscar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	// Fetch Join
	public List<Hotel> buscarPorHoteles();

	public List<Hotel> buscarPorDireccion(String direccion);
}
