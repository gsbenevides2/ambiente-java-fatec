package org.example;

public class CachorroDoberman extends Cachorro {
	public CachorroDoberman() {
		pularComportamento = new PularMedio();
		latirComportamento = new LatirNervoso();
	}
	public void mostrar() {
		System.out.println("Mostrando um Doberman");
	}
}
