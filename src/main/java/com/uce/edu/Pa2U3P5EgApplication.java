package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5EgApplication implements CommandLineRunner {
	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private ILibroService libroService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("INNER JOIN");
		List<Libro> libro = this.libroService.buscarPorLibros();
		for (Libro l : libro) {
			System.out.println(l);}

		List<Autor> autor = this.autorService.buscarPorNacionalidad("Ecuatoriana");
		for (Autor a : autor) {
			System.out.println(a);}

		System.out.println("LEFT JOIN");
		List<Ciudadano> ciudadano = this.ciudadanoService.buscarPorCiudadano();
		for (Ciudadano c : ciudadano) {
			System.out.println(c);}

		List<Ciudadano> ciudadano2 = this.ciudadanoService.buscarPorCedula("1718411745");
		for (Ciudadano c : ciudadano2) {
			System.out.println(c);}

		System.out.println("RIGTH JOIN");
		List<Empleado> empleado = this.empleadoService.buscarPorEmpleados();
		for (Empleado e : empleado) {
			System.out.println(e);}

		List<Libro> libro1 = this.libroService.buscarPorFechaPublicacion(LocalDateTime.of(2024, 1, 12, 18, 27));
		for (Libro l : libro1) {
			System.out.println(l);}

		System.out.println("FULL JOIN");
		List<Autor> autor2 = this.autorService.buscarPorAutor();
		for (Autor a : autor2) {
			System.out.println(a);}

		List<Factura> factura = this.facturaService.buscarPorNumeroF("0001-02569");
		for (Factura f : factura) {
			System.out.println(f);}

		System.out.println("FETCH JOIN");
		List<Hotel> hotel = this.hotelService.buscarPorHoteles();
		for (Hotel h : hotel) {
			System.out.println(h);}

		List<Hotel> hotel1 = this.hotelService.buscarPorDireccion("Shirys");
		for (Hotel h : hotel1) {
			System.out.println(h);}

	}
}
