package com.gsbenevides2.Abc;

import java.math.BigDecimal;

public class Residencial {
    private String nome;
    private Endereco endereco;
    private Integer avaliacao;
    private String telefone;
    private Integer preco;

    protected Residencial(
            String nome,
            Endereco endereco,
            Integer avaliacao,
            String telefone,
            Integer preco
    ) throws Exception {
        this.nome = nome;
        this.endereco = endereco;
        if(avaliacao < 0 || avaliacao > 5) throw new Exception("Avaliação menor do 0 ou maior que 5");
        this.avaliacao = avaliacao;
        this.telefone = telefone;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getPreco(){
        return preco;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Residencial resi)) return false;
        return resi.telefone.equals(this.telefone);
    }



}