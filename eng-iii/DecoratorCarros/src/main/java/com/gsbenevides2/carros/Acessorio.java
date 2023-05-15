package com.gsbenevides2.carros;

public abstract class Acessorio extends Veiculo{
    final Veiculo veiculo;

    public Acessorio(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getNome() {
        return veiculo.getNome() + " + " + nome;
    }

    public String getDescricao() {
        return veiculo.getDescricao() + " + " + descricao;
    }

    public double getPreco() {
        return veiculo.getPreco() + preco;
    }
}
