package com.uce.edu.funcional;

public class MetodosReferenciados {
	public String obetenerId() {
		// TODO Auto-generated method stub
		String cedula = "1718411745";
		cedula = cedula+"referenciado";
		return cedula;
	}
	
	public void procesar(String cadena) {
		// TODO Auto-generated method stub
		System.out.println(cadena);
		System.out.println("Se procesa la cadena");
	}
	
	public boolean evaluar(String cadena) {
		// TODO Auto-generated method stub
		return "Erika".contains(cadena);
		}
	
	public boolean procesar(Integer numero) {
		// TODO Auto-generated method stub
		return 8==numero;
		}
	
	public Ciudadano cambiar(Empleado empl) {
		// TODO Auto-generated method stub
		Ciudadano ciud = new Ciudadano();
		String nombre = empl.getNombreCompleto().split(" ")[0];
		String apellido = empl.getNombreCompleto().split(" ")[1];
		ciud.setNombre(nombre);
		ciud.setApellido(apellido);
		ciud.setProvincia("Chimborazo");
		return ciud;
		}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
		empl.setPais(empl.getPais()+ " de nacimiento.");
		return empl;
	}
	
}
