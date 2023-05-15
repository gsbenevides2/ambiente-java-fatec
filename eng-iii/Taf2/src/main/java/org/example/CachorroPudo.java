package org.example;

public class CachorroPudo extends Cachorro {
	public CachorroPudo() {
		latirComportamento = new LatirAtencao();
		pularComportamento = new PularBaixo();
	}
	@Override
	public void mostrar() {
		System.out.println("Mostrando um lindo Pudo");
	}

}
