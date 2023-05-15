package br.com.fatecmc.tarde.poo;

public class Principal {

	public static void main(String[] args) {

		Agencia agencia = new Agencia();

		Veiculo veiculo1 = new Veiculo("Onix", "Chevrolet", true, 128);
		Veiculo veiculo2 = new Veiculo("Corola Cross", "Toyota", true, 325);
		Veiculo veiculo3 = new Veiculo("Compass", "Jeep", true, 280);

		agencia.addItemReservavel(veiculo1);
		agencia.addItemReservavel(veiculo2);
		agencia.addItemReservavel(veiculo3);

		Hotel hotel1 = new Hotel("Hotel 1", 3, 425);
		Hotel hotel2 = new Hotel("Hotel 2", 4, 525);
		Hotel hotel3 = new Hotel("Hotel 3", 5, 825);

		agencia.addItemReservavel(hotel1);
		agencia.addItemReservavel(hotel2);
		agencia.addItemReservavel(hotel3);

		Ingresso ingresso1 = new Ingresso("Show do U2", 1250);
		Ingresso ingresso2 = new Ingresso("Show do Coldplay", 1550);
		agencia.addItemReservavel(ingresso1);
		agencia.addItemReservavel(ingresso2);

		Voo voo1 = new Voo("GRU", "NYT", 12, 2570);
		Voo voo2 = new Voo("GRU", "CGH", 0, 0);
		agencia.addItemReservavel(voo1);
		agencia.addItemReservavel(voo2);

		Pedido pedido = new Pedido();
		pedido.addReserva(new ReservaHotel(hotel1, 5));
		pedido.addReserva(new ReservaHotel(hotel3, 10));
		pedido.addReserva(new ReservaVoo(voo1));
		pedido.addReserva(new ReservaVeiculo(veiculo1, 10));
		pedido.addReserva(new ReservaIngresso(ingresso2));

		agencia.addPedido(pedido);
		System.out.printf("O total do pedido é R$ %.2f\n", pedido.calcularTotal());

	}

}
