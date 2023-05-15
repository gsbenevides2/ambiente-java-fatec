package com.gsbenevides2.Urna;

public class Eleitor {
    private String nome;
    private String numeroDoTitulo;
    private String numeroDaSessao;

    public Eleitor(String nome, String numeroDoTitulo, String numeroDaSessao){
        this.nome = nome;
        this.numeroDoTitulo = numeroDoTitulo;
        this.numeroDaSessao = numeroDaSessao;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNumeroDoTitulo(){
        return this.numeroDoTitulo;
    }

    public String getNumeroDaSessao(){
        return this.numeroDaSessao;
    }

    public boolean equals(Object obj){
        if(obj instanceof Eleitor){
            Eleitor eleitor = (Eleitor) obj;
            return eleitor.getNumeroDoTitulo().equals(this.getNumeroDoTitulo());
        }
        return false;
    }
}
