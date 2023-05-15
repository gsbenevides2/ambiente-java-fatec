package com.gsbenevides2.folhaDePagamento;

public class Funcionario {
    private String CPF;
    private String nome;
    public Funcionario(String CPF, String nome) {
        setCPF(CPF);
        setNome(nome);
    }
    public String getCPF() {
        return CPF;
    }
    private void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
