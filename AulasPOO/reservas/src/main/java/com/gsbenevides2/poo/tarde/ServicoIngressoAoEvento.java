package com.gsbenevides2.poo.tarde;

public class ServicoIngressoAoEvento extends ServicoDeReserva{
    private Evento evento;

    public ServicoIngressoAoEvento(Evento evento){
        setEvento(evento);
    }

    public Evento getEvento() {
        return evento;
    }
    private void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public double getValor() {
        return this.evento.getPreco();
    }
}