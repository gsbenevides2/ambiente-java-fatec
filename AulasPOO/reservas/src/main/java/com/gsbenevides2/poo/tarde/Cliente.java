package com.gsbenevides2.poo.tarde;

public class Cliente {
    private String nome;
    private CPF cpf;

    public Cliente(String nome, CPF cpf){
        setNome(nome);
        setCPF(cpf);
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    private void setCPF(CPF cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }
    private CPF getCPF(){
        return this.cpf;
    }
}
