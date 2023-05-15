package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.math.BigDecimal;
import java.util.HashMap;

class RespostaFornecedorDetran implements RespostaFornecedor {
    private  Consulta consulta;
    private String respostaPura;
    private BigDecimal custoDaRequisicao;

    RespostaFornecedorDetran(Consulta consulta, String respostaPura, BigDecimal custoDaRequisicao) {
        setConsulta(consulta);
        setRespostaPura(respostaPura);
        setCustoDaRequisicao(custoDaRequisicao);
    }

    private void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    private void setRespostaPura(String respostaPura) {
        this.respostaPura = respostaPura;
    }

    private void setCustoDaRequisicao(BigDecimal custoDaRequisicao) {
        this.custoDaRequisicao = custoDaRequisicao;
    }

    @Override
    public Fornecedor getFornecedor() {
        return FornecedorDetran.getInstance();
    }

    @Override
    public Consulta getConsulta() {
        return consulta;
    }

    @Override
    public String getRespostaPura() {
        return respostaPura;
    }

    @Override
    public SituacaoDoVeiculo getSituacaoVeiculo() {
        HashMap<String, SituacaoDoVeiculo> map = new HashMap<>();
        map.put("IPVA_ATRASADO", SituacaoDoVeiculo.IRREGULAR);
        map.put("DPVAT_ATRASADO", SituacaoDoVeiculo.IRREGULAR);
        map.put("MULTAS_PENDENTES", SituacaoDoVeiculo.IRREGULAR);
        map.put("LICENCIAMENTO_ATRASADO", SituacaoDoVeiculo.IRREGULAR);
        map.put("NADA_CONSTA", SituacaoDoVeiculo.REGULAR);
        map.put("VEICULO_NAO_ENCONTRADO", SituacaoDoVeiculo.REGULAR);
        map.put("FURTO_PROCURADO", SituacaoDoVeiculo.IRREGULAR);

        return map.get(respostaPura);
    }

    @Override
    public BigDecimal getCustoDaRequisicao() {
        return custoDaRequisicao;
    }
}
