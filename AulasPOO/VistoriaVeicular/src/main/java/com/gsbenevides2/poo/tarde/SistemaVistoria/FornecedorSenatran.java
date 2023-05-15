package com.gsbenevides2.poo.tarde.SistemaVistoria;

import com.gsbenevides2.poo.tarde.Utils.MakeHttpRequest;

import java.math.BigDecimal;

public class FornecedorSenatran implements FornecedorPrivado{
    private static Fornecedor instance;
    private FornecedorSenatran() {
    }
    public static Fornecedor getInstance() {
        if (instance == null) {
            instance = new FornecedorSenatran();
        }
        return instance;
    }

    private String id = "senatran";
    private String nome = "Secretária Nacional de Trânsito (Senatran)";
    private BigDecimal valor = new BigDecimal("500.00");

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public RespostaFornecedor fazerRequisicao(Consulta consulta) throws Exception {
        String url = "http://localhost:3000/senatran/"+ consulta.getPlaca();
        String respostaPura = MakeHttpRequest.get(url);

        return new RespostaFornecedorSenatran(consulta, respostaPura, getValor());
    }
}
