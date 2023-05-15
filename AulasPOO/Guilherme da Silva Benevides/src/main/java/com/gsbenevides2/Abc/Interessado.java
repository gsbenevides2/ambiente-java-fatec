package com.gsbenevides2.Abc;

public class Interessado {
    private String nome;
    private String telefone;
    private String primeiroNomeIdoso;
    private String email;

    protected Interessado(
            String nome,
            String telefone,
            String primeiroNomeIdoso,
            String email
    ) {
        this.nome = nome;
        this.telefone = telefone;
        this.primeiroNomeIdoso = primeiroNomeIdoso;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Interessado interessado)) return false;
        return interessado.getTelefone().equals(this.getTelefone());
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getPrimeiroNomeIdoso() {
        return primeiroNomeIdoso;
    }

    public String getEmail() {
        return email;
    }
}