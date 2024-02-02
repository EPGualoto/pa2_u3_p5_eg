package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService {
	@Autowired
	private IAutorRepository iAutorRepository;

	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRepository.insertar(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iAutorRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.iAutorRepository.actualizar(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iAutorRepository.eliminar(id);
	}

	@Override
	public List<Autor> buscarPorAutor() {
		// TODO Auto-generated method stub
		return this.iAutorRepository.seleccionarPorAutor();
	}

	@Override
	public List<Autor> buscarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.iAutorRepository.seleccionarPorNacionalidad(nacionalidad);
	}

}
