package com.gsbenevides2.poo.tarde;

public class Evento  {
    private String nome;
    private double preco;

    public Evento(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    private void setPreco(double preco) {
        this.preco = preco;
    }

}
