package com.uce.edu.ventas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IClienteService iClienteService;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		// TransactionSynchronizationManager de support
		BigDecimal valor = new BigDecimal(100);
		valor = valor.multiply(new BigDecimal(0.12));
		factura.setValorIva(valor);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Paso el insert de factura");
		this.iFacturaRepository.insertar(factura);
		System.out.println("Paso el insert de cliente");
		this.iClienteService.guardar(cliente);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	public List<Factura> buscarFacturas() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarTodos();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este metodo es de prueba");
		System.out.println("Prueba:" + TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override
	// @Transactional(value = TxType.REQUIRED)
	public void pruebaSupport() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura:" + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaSupports();
	}

	@Transactional(value = TxType.REQUIRED)
	public void pruebaSupport2() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura:" + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaSupports();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura:" + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaNever();

	}
}
