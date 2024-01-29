package com.uce.edu.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.reservas.repository.IHotelRepository;
import com.uce.edu.reservas.repository.modelo.Habitacion;
import com.uce.edu.reservas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHotelRepository.insertar(hotel);
	}

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHotelRepository.actualizar(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iHotelRepository.eliminar(id);
	}
	
	@Override
	public List<Hotel> buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorDireccion(direccion);
	}

	@Override
	public List<Habitacion> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorId(id);
	}

	@Override
	public List<Hotel> buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorClase(clase);
	}

	@Override
	public List<Habitacion> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorNumero(numero);
	}
}
