package br.com.fatecmc.tarde.poo;

public class ReservaVeiculo implements Reserva {

	private Veiculo veiculo;
	private int duracaoEmDias;

	public ReservaVeiculo(Veiculo veiculo, int duracaoEmDias) {
		setVeiculo(veiculo);
		setDuracaoEmDias(duracaoEmDias);
	}

	@Override
	public double calcularValor() {
		return duracaoEmDias * veiculo.getValorDiaria();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getDuracaoEmDias() {
		return duracaoEmDias;
	}

	public void setDuracaoEmDias(int duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}

}
