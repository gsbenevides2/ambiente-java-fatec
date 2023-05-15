package br.com.fatecmc.tarde.poo;

public class ReservaVoo implements Reserva {

	private Voo voo;

	public ReservaVoo(Voo voo) {
		setVoo(voo);
	}

	@Override
	public double calcularValor() {
		return voo.getValor();
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

}
