package com.gsbenevides2.bar;

public abstract class CoquetelDecorator extends Coquetel {
    final Coquetel coquetel;

    public CoquetelDecorator(Coquetel coquetel) {
        this.coquetel = coquetel;
    }

    public String getNome() {
        return coquetel.getNome() + " + " + nome;
    }

    public double getPreco() {
        return coquetel.getPreco() + preco;
    }
}
