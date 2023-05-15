package org.example;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		try(Scanner entrada = new Scanner(System.in)){
			System.out.print("Informe a dist�ncia: ");
			int distancia = entrada.nextInt();
			
			System.out.print("Qual o tipo de frete (1) Normal, (2) Sedex, (3) Sedex10: ");
			int opcaoFrete = entrada.nextInt();
			
			TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete -1];
			Frete frete = tipoFrete.obterFrete();
			
			double preco = frete.calcularPreco(distancia);
			
			System.out.printf("O valor total � de R$%.2f", preco);
		}
	}
}
