package com.gsbenevides2.poo.tarde;

public class ServicoVoo extends ServicoDeReserva{
    private Voo voo;

    public ServicoVoo(Voo voo){
        setVoo(voo);
    }

    private void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Voo getVoo() {
        return voo;
    }

    @Override
    public double getValor() {
        return this.voo.getDuracaoDoVoo() * 100.0;
    }
}
