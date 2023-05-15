package com.gsbenevides2.poo.tarde;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Cliente cliente;
    private List<ServicoDeReserva> servicos = new ArrayList<>();

    public Reserva(Cliente cliente) {
        setCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addServico(ServicoDeReserva servico){
        servicos.add(servico);
    }
    public double getValor() {
        double subtotal = 0;
        for (ServicoDeReserva servico : servicos) {
            subtotal += servico.getValor();
        }
        return subtotal;
    }

}
