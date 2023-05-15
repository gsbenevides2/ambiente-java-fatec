package br.com.fatecmc.tarde.poo;

public class ReservaHotel implements Reserva {

	private Hotel hotel;
	private int duracaoEmDias;

	public ReservaHotel(Hotel hotel, int duracaoEmDias) {
		setHotel(hotel);
		setDuracaoEmDias(duracaoEmDias);
	}
	
	@Override
	public double calcularValor() {
		return duracaoEmDias * hotel.getValorDiaria();
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getDuracaoEmDias() {
		return duracaoEmDias;
	}

	public void setDuracaoEmDias(int duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}

}
