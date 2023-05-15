package com.gsbenevides2.Urna;

public class Partido {
    private String nome;
    private String numero;

    public Partido(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNumero(){
        return this.numero;
    }
}
