package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

class RespostaFornecedorSenatran implements RespostaFornecedor {
    private Consulta consulta;
    private String respostaPura;
    private BigDecimal custoDaRequisicao;

    RespostaFornecedorSenatran(Consulta consulta, String respostaPura, BigDecimal custoDaRequisicao) {
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
        return FornecedorSenatran.getInstance();
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
        map.put("IPVA", SituacaoDoVeiculo.IRREGULAR);
        map.put("DPVAT", SituacaoDoVeiculo.IRREGULAR);
        map.put("INFRACOES", SituacaoDoVeiculo.IRREGULAR);
        map.put("LICENCIAMENTO", SituacaoDoVeiculo.IRREGULAR);
        map.put("OK", SituacaoDoVeiculo.REGULAR);
        map.put("VEICULO_NAO_ENCONTRADO", SituacaoDoVeiculo.REGULAR);
        map.put("POLICIA", SituacaoDoVeiculo.IRREGULAR);

        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (respostaPura.contains(key)) {
                return map.get(key);
            }
        }
        return SituacaoDoVeiculo.IRREGULAR;
    }

    @Override
    public BigDecimal getCustoDaRequisicao() {
        return custoDaRequisicao;
    }
}
