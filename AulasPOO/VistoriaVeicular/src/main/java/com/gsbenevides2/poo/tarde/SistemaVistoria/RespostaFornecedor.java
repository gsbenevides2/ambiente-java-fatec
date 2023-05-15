package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.math.BigDecimal;

public interface RespostaFornecedor {
    Fornecedor getFornecedor();
    Consulta getConsulta();
    String getRespostaPura();
    SituacaoDoVeiculo getSituacaoVeiculo();
    BigDecimal getCustoDaRequisicao();

}
