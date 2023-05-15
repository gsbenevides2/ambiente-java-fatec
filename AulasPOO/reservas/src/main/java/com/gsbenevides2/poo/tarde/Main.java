package com.gsbenevides2.poo.tarde;
/*
Considere um sistema de reservas de viagens onde os clientes podem escolher entre voos, hotéis, aluguel de veículos e ingressos.
Cada tipo de reserva tem regras e preços diferentes.
Para simplificar, o voo tem um preço em função da duração da viagem.
O hotel tem seu preço definido em função do valor da diária e do total de diárias.
O aluguel de veículo o mesmo que o hotel.
Os ingressos tem um preço pré-definido em função do evento.
O sistema deve ser capaz de calcular o preço total da reserva com base nos serviços selecionados.
Implemente uma solução orientada a objetos usando herança, polimorfismo, classes abstratas, sobrescrita (se aplicável) e construção.

Possiveis Tipos e seus atributos:
Cliente: cpf, nome
Reserva: cliente
Abstrato -> ServicosDeReserva: Abstrato -> getValor()
  ServicoVoo: duracaoDoVoo
  ServicoHotel: valorDaDiaria, quantidadeDeDiarias
  ServicoAluguelVeicular: valorDaDiaria, quantidadeDeDiarias
  ServicoIngresso: preco
GerenciadorDeServicos: servicos



 */
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Voo voo1 = new Voo("213", 5);
        Voo voo2 = new Voo("214", 10);
        Hotel hotel1 = new Hotel("Vila Galé", 100);
        Hotel hotel2 = new Hotel("Mansão Foster", 200);
        Evento evento1 = new Evento("Rock in Rio", 100);
        Evento evento2 = new Evento("Lolapaluza", 200);
        Veiculo veiculo1 = new Veiculo("Fusca", 100);
        Veiculo veiculo2 = new Veiculo("Ferrari", 200);

        Cliente cliente1 = new Cliente("Paulo da Silva", new CPF("012.680.958-50"));
        Cliente cliente2 = new Cliente("Rogerio Barbosa", new CPF("568.409.328-00"));

        Reserva reserva1 = new Reserva(cliente1);
        reserva1.addServico(new ServicoVoo(voo1));
        reserva1.addServico(new ServicoHotel(hotel1,2));
        reserva1.addServico(new ServicoIngressoAoEvento(evento1));
        reserva1.addServico(new ServicoAluguelVeicular(veiculo1, 2));
        sistema.addReserva(reserva1);
        System.out.println("A reserva 1 custa no total de: R$ " + reserva1.getValor());
        Reserva reserva2 = new Reserva(cliente2);
        reserva2.addServico((new ServicoVoo(voo2)));
        reserva2.addServico(new ServicoHotel(hotel2,2));
        reserva2.addServico(new ServicoIngressoAoEvento(evento2));
        reserva2.addServico(new ServicoAluguelVeicular(veiculo2,2));
        sistema.addReserva(reserva2);
        System.out.println("A reserva 2 custa no total de: R$ " + reserva2.getValor());
    }
}