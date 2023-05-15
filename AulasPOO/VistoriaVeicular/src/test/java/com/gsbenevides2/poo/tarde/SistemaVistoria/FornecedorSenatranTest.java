package com.gsbenevides2.poo.tarde.SistemaVistoria;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FornecedorSenatranTest {
    @Test
    public void testeFornecedor() {
        Fornecedor fornecedor = FornecedorSenatran.getInstance();
        Assert.assertEquals("Secretária Nacional de Trânsito (Senatran)", fornecedor.getNome());
        Assert.assertEquals("senatran", fornecedor.getId());
        Assert.assertEquals(0, fornecedor.getValor().compareTo(new BigDecimal("500.00")));
    }

    @Test
    public void testeConsultaSenatran() throws Exception {
        String placa = "BXK-0731";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);

        Assert.assertEquals("OK", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.REGULAR, requisicao.getSituacaoVeiculo());

        Assert.assertEquals(1, consulta.getRequisicoes().size());
        Assert.assertEquals(consulta.getId(), requisicao.getConsulta().getId());
        Assert.assertEquals(senatran, requisicao.getFornecedor());
        Assert.assertEquals(senatran.getValor(), requisicao.getCustoDaRequisicao());
    }

    @Test
    public void testeConsultaIPVAATRASADO() throws Exception {
        String placa = "BXK-0727";
        Consulta consulta = new Consulta(placa);

        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);

        Assert.assertEquals("SP-IPVA", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaDPVATATRASADO() throws Exception {
        String placa = "BXK-0728";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);

        Assert.assertEquals("MG-DPVAT", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }


    @Test
    public void testeConsultaMULTASPENDENTES() throws Exception {
        String placa = "BXK-0729";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);

        Assert.assertEquals("RJ-INFRACOES", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaLICENCIAMENTOATRASADO() throws Exception {
        String placa = "BXK-0730";
        Consulta consulta = new Consulta(placa);
        Fornecedor senatran = FornecedorSenatran.getInstance();
        consulta.criar();
        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);
        Assert.assertEquals("MG-LICENCIAMENTO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaVEICULONAOENCONTRADO() throws Exception {
        String placa = "BXK-0732";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);
        Assert.assertEquals("VEICULO_NAO_ENCONTRADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.REGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaFURTOPROCURADO() throws Exception {
        String placa = "BXK-0733";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor senatran = FornecedorSenatran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(senatran);
        Assert.assertEquals("BA-POLICIA", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

}
