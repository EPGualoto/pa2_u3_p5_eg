package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5EgApplication implements CommandLineRunner {
	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * System.out.println("Nombre Hilo: " + Thread.currentThread().getName()); long
		 * tiempoInicial = System.currentTimeMillis(); for (int i = 1; i <= 100; i++) {
		 * Cliente cliente = new Cliente(); cliente.setNombre("CN" + i);
		 * cliente.setApellido("CA" + i); this.clienteService.guardar(cliente); }
		 * 
		 * long tiempoFinal = System.currentTimeMillis();
		 * 
		 * // long tiempoTranscurrido = (tiempoFinal-tiempoInicial);
		 * 
		 * long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		 * 
		 * System.out.println("El tiempo transcurrido en seg: " + tiempoTranscurrido);
		 * // El tiempo transcurrido en seg: 101
		 * 
		 * 
		 * //Programación en paralelo (Multihilo - MulltiThread)
		 * System.out.println("Nombre Hilo: " + Thread.currentThread().getName()); long
		 * tiempoInicial = System.currentTimeMillis();
		 * 
		 * List<Cliente> listaCliente = new ArrayList<>(); for (int i = 1; i <= 100;
		 * i++) { Cliente cliente = new Cliente(); cliente.setNombre("CN" + i);
		 * cliente.setApellido("CA" + i); listaCliente.add(cliente); }
		 * listaCliente.stream().forEach(cliente ->
		 * this.clienteService.guardar(cliente)); long tiempoFinal =
		 * System.currentTimeMillis();
		 * 
		 * long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		 * System.out.println("El tiempo transcurrido en seg: " + tiempoTranscurrido);
		 * //El tiempo transcurrido en seg: 101
		 * 
		 * System.out.println("Nombre Hilo: " + Thread.currentThread().getName()); long
		 * tiempoInicial = System.currentTimeMillis();
		 * 
		 * List<Cliente> listaCliente = new ArrayList<>(); for (int i = 1; i <= 100;
		 * i++) { Cliente cliente = new Cliente(); cliente.setNombre("CN" + i);
		 * cliente.setApellido("CA" + i); listaCliente.add(cliente); }
		 * listaCliente.parallelStream().forEach(cliente ->
		 * this.clienteService.guardar(cliente)); long tiempoFinal =
		 * System.currentTimeMillis();
		 * 
		 * long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		 * System.out.println("El tiempo transcurrido en seg: " + tiempoTranscurrido);
		 */

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for (int i = 1; i <= 5; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			if(cliente.getNombre().startsWith("C")) {
				
			this.clienteService.guardar(cliente); //demora 1 segundo
			}
		}

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial);

		System.out.println("El tiempo transcurrido en seg: " + tiempoTranscurrido);
		System.out.println("Se ha mandado ha procesar sus 500 clientes, puede continuar con sus actividades.");
		// El tiempo transcurrido en seg: 10
	}
}
