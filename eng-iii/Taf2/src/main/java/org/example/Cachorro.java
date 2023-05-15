package org.example;

public abstract class Cachorro {
	protected LatirComportamento latirComportamento;
	protected PularComportamento pularComportamento;
	
	public void pular(){
		this.pularComportamento.pular();
	}
	
	public void latir() {
		this.latirComportamento.latir();
	}
	
	public abstract void mostrar();
}
