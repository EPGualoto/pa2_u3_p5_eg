package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero =: numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size();  //le digo que cargue el detalle bajo demanda
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		//SQL: SELECT * FROM Factura f inner join detalle_factura d on f.fact_id = d.defa_id_factura
		//JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d //f.detalleFactura se pone la referencia
		
		//Hibernet:
		//select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.defa_id_factura
		//El inner join con el join es lo mismo en el jpql, nos permite consultar lo mismo.
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista =myQuery.getResultList();
		/*for(Factura f:lista) {
			f.getDetalleFactura().size(); //señal
		}*/
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRigthJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista =myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista =myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista =myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		
		//SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id_factura
		
		//Usando JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE (didactica)f.id = d.factura.id
		//d.factura --> representacion de una factura en una factura --> f= d.factura --> f es una representación de factura
		
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f= d.factura", Factura.class);
		List<Factura> lista =myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFactura().size(); //señal
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//JPQL INNER JOIN: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		//JPQL: SELECT f FROM Factura f JOIN FETCH f.detalleFactura d
		TypedQuery<Factura> mYQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);
		
		return mYQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}
	
	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		//SELECT * FROM Factura WHERE fecha >= fechaActual
		//Lista
		//Recorrer la lista
		//Por cada factura seteo la nueva fecha
		//Actualizar cada factura
		//SQL: UPDATE Factura set fact_fecha = : fechaNueva WHERE fact_fecha >= fechaActual
		//JPQL: UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >= fechaActual
		Query myQuery = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :fechaNueva WHERE f.fecha >= : fechaActual");
		myQuery.setParameter("fechaNueva",fechaNueva);
		myQuery.setParameter("fechaActual",fechaActual);
		return myQuery.executeUpdate();
		//Cantidad de registros afectados/actualizados.
		
	}
	
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		//Factura con todos sus atributos
		//detalleFactura
		//Delete de los detalles
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		//SQL: DELETE FROM Factura WHERE fact_numero = : numero
		//JPQL: DELTE FROM Factura f WHERE f.numero =: numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =: numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		//SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f
		// o SELECT f.numero, f.fecha FROM Factura f
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f", FacturaDTO.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarPorNumeroF(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = entityManager.createQuery(
				"SELECT f FROM Factura f FULL JOIN f.detalleFactura df WHERE f.numero = :numero", Factura.class);
		myQuery.setParameter("numero", numero);
		List<Factura> facturas = myQuery.getResultList();
		for (Factura f : facturas) {
			f.getDetalleFactura().size();
		}
		return facturas;
	}
}
