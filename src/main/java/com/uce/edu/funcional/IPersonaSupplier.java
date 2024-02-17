package com.uce.edu.funcional;

@FunctionalInterface
//usamos generico: retorna tipo de dato generico.
public interface IPersonaSupplier <T> {
	public T getId();

}
