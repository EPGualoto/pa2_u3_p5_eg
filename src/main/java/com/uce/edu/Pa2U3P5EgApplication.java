package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.reservas.repository.modelo.Habitacion;
import com.uce.edu.reservas.repository.modelo.Hotel;
import com.uce.edu.reservas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5EgApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INNER JOIN");
		List<Hotel> hotel = this.hotelService.buscarPorDireccion("Shirys");
		for (Hotel h : hotel) {
			System.out.println(h);
		}

		System.out.println("RIGHT JOIN");
		List<Habitacion> habi1 = this.hotelService.buscarPorId(1);
		for (Habitacion h : habi1) {
			System.out.println(h.getHotel());
		}

		System.out.println("LEFT JOIN");
		List<Hotel> hotel2 = this.hotelService.buscarPorClase("FAMILIAR");
		for (Hotel h : hotel2) {
			System.out.println(h);
		}

		System.out.println("FULL JOIN");
		List<Habitacion> habi3 = this.hotelService.buscarPorNumero("A36");
		for (Habitacion h : habi3) {
			System.out.println(h.getHotel());
		}
	}

}
