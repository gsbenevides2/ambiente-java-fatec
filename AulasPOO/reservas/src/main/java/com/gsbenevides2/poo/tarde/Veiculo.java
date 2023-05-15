package com.gsbenevides2.poo.tarde;

public class Veiculo {
    private String modelo;
    private double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        setModelo(modelo);
        setValorDiaria(valorDiaria);
    }

    public String getModelo() {
        return modelo;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    private void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
