package com.gsbenevides2.poo.tarde;

public class Voo {
    private String numero;
    private int duracaoDoVoo;

    public Voo(String numero, int duracaoDoVoo) {
        setNumero(numero);
        setDuracaoDoVoo(duracaoDoVoo);
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }
    private void setDuracaoDoVoo(int duracaoDoVoo) {
        this.duracaoDoVoo = duracaoDoVoo;
    }

    public String getNumero() {
        return numero;
    }
    public int getDuracaoDoVoo() {
        return this.duracaoDoVoo;
    }
}
