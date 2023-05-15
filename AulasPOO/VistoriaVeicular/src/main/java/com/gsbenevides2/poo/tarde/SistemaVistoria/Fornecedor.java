package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.math.BigDecimal;

public interface Fornecedor {
    String getId();
    String getNome();
    BigDecimal getValor();


}

interface FornecedorPrivado extends Fornecedor{
    RespostaFornecedor fazerRequisicao(Consulta consulta) throws Exception;
}
