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
	@Transactional(value =  TxType.REQUIRES_NEW ) //T2
	//begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			this.iClienteRepository.insertar(cliente);
		}catch (Exception e) {
			System.out.println("ERROR");
		}
			//commit
	}

}
