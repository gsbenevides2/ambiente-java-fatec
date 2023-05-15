package br.com.fatecmc.tarde.poo;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

	private List<ItemReservavel> itensReservaveis = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();
	
	public void addItemReservavel(ItemReservavel itemReservavel) {
		itensReservaveis.add(itemReservavel);
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
}
