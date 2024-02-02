package com.uce.edu.repository.modelo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
//PRIMERA FORMA
//PRINCIPAL
@NamedQuery(name = "Autor.queryBuscarPorNacionalidad", query = "SELECT a FROM Autor a WHERE a.nacionalidad = : nacionalidad ")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
	@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
	@Column(name = "auto_id")
	private Integer id;
	
	@Column(name = "auto_nombre")
	private String nombre;
	
	@Column(name = "auto_nacionalidad")
	private String nacionalidad;
	
	@ManyToMany(mappedBy = "autores" , cascade = CascadeType.ALL)
	private Set<Libro> libros;
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
}
