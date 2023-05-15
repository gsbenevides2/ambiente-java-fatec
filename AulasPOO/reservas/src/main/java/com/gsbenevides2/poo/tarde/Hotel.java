package com.gsbenevides2.poo.tarde;

public class Hotel {
    private String nome;
    private double valorDiaria;

    public Hotel(String nome, double valorDiaria){
        setNome(nome);
        setValorDiaria(valorDiaria);
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    private void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getNome() {
        return nome;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
}
