package br.com.fatecmc.tarde.poo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Reserva> reservas = new ArrayList<>();

	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public double calcularTotal() {
		double total = 0;
		for(Reserva reserva: reservas) {
			total += reserva.calcularValor();
		}
		return total;
	}
	
}
