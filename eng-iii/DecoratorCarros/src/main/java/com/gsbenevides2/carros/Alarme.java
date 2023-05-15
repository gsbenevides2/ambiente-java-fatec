package com.gsbenevides2.carros;

public class Alarme extends  Acessorio{
        public Alarme(Veiculo veiculo) {
            super(veiculo);
            nome = "Alarme";
            preco = 1000.0;
            descricao = "Alarme de ultima geração";
        }
}
