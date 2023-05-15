package com.gsbenevides2.poo.tarde.SistemaVistoria;

import com.gsbenevides2.poo.tarde.Utils.MakeHttpRequest;

import java.math.BigDecimal;

public class FornecedorDetran implements FornecedorPrivado {
    private static Fornecedor instance;
    private FornecedorDetran() {
    }
    public static Fornecedor getInstance() {
        if (instance == null) {
            instance = new FornecedorDetran();
        }
        return instance;
    }

    private String id = "detran-sp";
    private String nome = "Departamento Estadual de Trânsito de São Paulo(DetranSP)";
    private BigDecimal valor = new BigDecimal("100.00");

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
        String url = "http://localhost:3000/detran/"+ consulta.getPlaca();
        String respostaPura = MakeHttpRequest.get(url);
        BigDecimal custoDaRequisicao = getValor();
        return new RespostaFornecedorDetran(consulta, respostaPura, custoDaRequisicao);
    }
}
