package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	@Transactional(value =  TxType.REQUIRED ) //T2
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			
		this.iClienteRepository.insertar(cliente);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}