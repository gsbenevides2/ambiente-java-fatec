package br.com.fatecmc.tarde.poo;

public class ReservaIngresso implements Reserva {

	private Ingresso ingresso;

	public ReservaIngresso(Ingresso ingresso) {
		setIngresso(ingresso);
	}

	@Override
	public double calcularValor() {
		return ingresso.getValor();
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

}
