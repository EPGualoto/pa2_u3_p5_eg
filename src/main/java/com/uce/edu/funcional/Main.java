package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println("---- SUPPLIER ----");
		// Clases:
		System.out.println("Clases:");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		System.out.println("Lambdas:");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1718411745";
			cedula = cedula + "cantón";
			return cedula;
		};
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "1718411745" + "país";
		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		// Métodos referenciados
		System.out.println("Métodos referenciados:");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obetenerId;
		System.out.println(supplierLambda4.getId());

		// 2. Consumer
		System.out.println("---- CONSUMER ----");
		// Clases
		System.out.println("Clases:");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		// Lambda
		System.out.println("Lambdas:");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");

		// Métodos referenciados
		System.out.println("Métodos referenciados:");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Erika referenciado");

		// 3. Predicate
		System.out.println("---- PREDICATE ----");
		// Lambdas
		System.out.println("Lambdas:");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Erika".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));

		// Métodos referenciados
		System.out.println("Métodos referenciados:");
		IPersonaPredicate<String> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar("c"));

		IPersonaPredicate<Integer> predicate3 = met::procesar;
		System.out.println(predicate3.evaluar(8));

		// 4. Function
		System.out.println("---- FUNCTION ----");
		// Lambdas
		System.out.println("Lambdas:");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + "" + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Gualoto");
		ciud.setNombre("Erika");
		ciud.setProvincia("Pichincha");

		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);

		// Métodos referenciados
		System.out.println("Métodos referenciados:");
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Daniel Tobar");
		empl2.setPais("Ecuador");

		IPersonaFunction<Ciudadano, Empleado> function1 = met::cambiar;
		Ciudadano ciud2 = function1.aplicar(empl2);
		System.out.println(ciud2);

		// 5. Unary Operator
		System.out.println("---- UNARY OPERATOR ----");
		// Lambdas
		System.out.println("Lambdas:");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda2.aplicar(10));

		// Métodos referenciados
		System.out.println("Métodos referenciados:");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
		Empleado empl3 = unary3.aplicar(empl2);
		System.out.println(empl3);

		System.out.println("---- Implementación de interfaces funcionales mediante ----");
		// 1. Supplier
		System.out.println("Supplier JAVA");
		Stream<String> lista = Stream.generate(() -> "465465465" + "pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));

		// 2.Consumer
		System.out.println("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 67, 8, 5, 4, 85, 74);
		listaNumeros.forEach(numero -> {
			System.out.println("Se inserta");
			System.out.println(numero);
		});

		// for(Integer numero:lista2) {
		// System.out.println("Se inserta");
		// System.out.println(numero);
		// }

		// 3. Predicate
		// Filter va recibir una implementación de la interface predicate
		System.out.println("Predicate JAVA");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> {
			return numero >= 10;
		});
		listaFiltrada.forEach(numero -> System.out.println(numero));

		// 4. Function
		System.out.println("Function JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return "Num: " + numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		//-------Ejemplo 2 Function-------
		Ciudadano ciud01 = new Ciudadano();
		ciud01.setApellido("Gualoto");
		ciud01.setNombre("Erika");
		ciud01.setProvincia("Pichincha");
		
		Ciudadano ciud02 = new Ciudadano();
		ciud02.setApellido("Teran");
		ciud02.setNombre("Daniel");
		ciud02.setProvincia("Pichincha");
		
		Ciudadano ciud03 = new Ciudadano();
		ciud03.setApellido("Jacome");
		ciud03.setNombre("Viviana");
		ciud03.setProvincia("Pichincha");
		
		List<Ciudadano> listaCiudadano = Arrays.asList(ciud01, ciud02, ciud03);
		Stream<Empleado> listaEmpleado = listaCiudadano.stream().map(ciudadano -> {
			Empleado empl01 = new Empleado();
			empl01.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl01.setPais("Ecuador");
			}
			return empl01;
		});
		listaEmpleado.forEach(empleado -> System.out.println(empleado));
		
		//5. Unary Operator
		System.out.println("Unary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50; //procesado
			return numero;
		});
		listaNumeros2.forEach(numero -> System.out.println(numero));
		
	}
}
