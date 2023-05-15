package org.example;

public class Main {
	public static void main(String[] args) {
		Cachorro dobermann = new CachorroDoberman();
		dobermann.mostrar();
		dobermann.pular();
		dobermann.latir();
		
		Cachorro pudo = new CachorroPudo();
		pudo.mostrar();
		pudo.pular();
		pudo.latir();
	}
}
