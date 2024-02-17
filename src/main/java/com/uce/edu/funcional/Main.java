package com.uce.edu.funcional;

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
		
		IPersonaSupplier<String> supplierLambda2 = () -> "1718411745"+"país";
		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50)/ Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		
		//Métodos referenciados
		
		//2. Consumer
		System.out.println("\n"+"---- CONSUMER ----");
		//Clases
		System.out.println("Clases:");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		//Lambda
		System.out.println("Lambdas:");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		
		//3. Predicate
		System.out.println("\n"+"---- PREDICATE ----");
		//Lambdas
		System.out.println("Lambdas:");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda2 = letra -> "Erika".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));
	}

}
