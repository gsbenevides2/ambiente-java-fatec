package br.com.fatecmc.tarde.poo;

public class Veiculo implements ItemReservavel {

	private String nome;
	private String marca;
	private boolean automatico;
	private double valorDiaria;

	public Veiculo(String nome, String marca, boolean automatico, double valorDiaria) {
		setNome(nome);
		setMarca(marca);
		setAutomatico(automatico);
		setValorDiaria(valorDiaria);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
}
