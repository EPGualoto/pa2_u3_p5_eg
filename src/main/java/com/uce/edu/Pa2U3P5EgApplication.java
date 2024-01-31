package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5EgApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UPDATE");
		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50),
				LocalDateTime.of(2024, 1, 22, 23, 59));
		System.out.println("Cantidad de registros/filas actualizados");
		System.out.println(cantidad);

		System.out.println("DELETE");
		//int cantidad2 = this.facturaService.borrarPorNumero("0001-02569");
		int cantidad2 = this.facturaService.borrarPorNumero("0001-0249");
		System.out.println("Cantidad de registros/filas eliminados");
		System.out.println(cantidad2);
		
		//Nos sirve para borrar todo los detalles
		//this.facturaService.borrar(3);
		
		//DTO: Data Transfer Object - Patron de diseño
		System.out.println("DTO");
		List<FacturaDTO> listaDTO = this.facturaService.buscarFacturasDTO();
		for(FacturaDTO fDTO: listaDTO) {
			System.out.println(fDTO);
		}

	}
}
