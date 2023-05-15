package org.example;

public class Sedex10 implements Frete{
	@Override
	public double calcularPreco(int distancia) {
		return distancia * 1.85 + 22;
	}
}
