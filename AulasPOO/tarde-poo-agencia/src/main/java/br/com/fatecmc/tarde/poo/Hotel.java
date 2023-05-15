package br.com.fatecmc.tarde.poo;

public class Hotel implements ItemReservavel {

	private String nome;
	private int estrelas;
	private double valorDiaria;
	
	public Hotel(String nome, int estrelas, double valorDiaria) {
		setNome(nome);
		setEstrelas(estrelas);
		setValorDiaria(valorDiaria);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
}
