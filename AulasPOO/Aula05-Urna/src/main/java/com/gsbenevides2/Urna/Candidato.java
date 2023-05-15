package com.gsbenevides2.Urna;

import java.util.Arrays;

public class Candidato {
    private Cargo cargo;
    private String nome;
    private String numero;
    private Partido patido;

    public Candidato(Cargo cargo, String nome, String numero, Partido partido){
        this.cargo = cargo;
        this.nome = nome;


        Boolean verifyIsBlank = Arrays.stream(numero.split("")).allMatch(v->{
           return v.equals("0");
        });

        if(verifyIsBlank == true)
            throw new IllegalArgumentException("O número do candidato não pode ser somente 0. Esse é o código para anular o voto.");

        if(numero.startsWith(partido.getNumero()) == false)
            throw new IllegalArgumentException("Código do partido discrepante");

        this.numero = numero;
        this.patido = partido;
    }

    public Cargo getCargo(){
        return this.cargo;
    }
    public String getNome(){
        return this.nome;
    }
    public String getNumero(){
        return this.numero;
    }
    public Partido getPartido(){
        return this.patido;
    }
}
