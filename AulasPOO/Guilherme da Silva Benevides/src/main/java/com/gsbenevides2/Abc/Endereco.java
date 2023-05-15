package com.gsbenevides2.Abc;

public class Endereco {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Regiao regiao;

    public Endereco(String logradouro, Integer numero, String bairro, String cidade,String estado, Regiao regiao){
        this.bairro = bairro;
        this.logradouro =logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao =regiao;
    };

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public String toString(){
        return this.logradouro + " Bairro:" + this.bairro;
    }
}