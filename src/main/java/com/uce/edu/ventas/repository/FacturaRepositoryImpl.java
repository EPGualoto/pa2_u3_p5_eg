package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero =: numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size(); // le digo que cargue el detalle bajo demanda
		return fact;
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		// Factura con todos sus atributos
		// detalleFactura
		// Delete de los detalles
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		// SQL: DELETE FROM Factura WHERE fact_numero = : numero
		// JPQL: DELTE FROM Factura f WHERE f.numero =: numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =: numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarTodos() {
		// TODO Auto-generated method stub
		// SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,
		// f.fecha) FROM Factura f
		// o SELECT f.numero, f.fecha FROM Factura f
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f", Factura.class);
		return myQuery.getResultList();
	}

	/*
	 * @Transactional(value = TxType.NOT_SUPPORTED) public Factura buscar() { return
	 * null; //SELECT }
	 */
}
