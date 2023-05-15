package com.gsbenevides2.carros;

public class Radio extends Acessorio{
    public Radio(Veiculo veiculo) {
        super(veiculo);
        nome = "Radio";
        preco = 1000.0;
        descricao = "Radio de ultima geração";
    }
}
