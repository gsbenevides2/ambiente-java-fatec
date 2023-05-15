package com.gsbenevides2.poo.tarde.SistemaVistoria;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FornecedorDetranTest {

    @Test
    public void testeFornecedor() {
        Fornecedor fornecedor = FornecedorDetran.getInstance();
        Assert.assertEquals("Departamento Estadual de Trânsito de São Paulo(DetranSP)", fornecedor.getNome());
        Assert.assertEquals("detran-sp", fornecedor.getId());
        Assert.assertEquals(0, fornecedor.getValor().compareTo(new BigDecimal("100.00")));
    }

    @Test
    public void testeConsultaDetran() throws Exception {
        String placa = "BXK-0731";
        Consulta consulta = new Consulta(placa);
        Fornecedor detran = FornecedorDetran.getInstance();
        consulta.criar();
        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("NADA_CONSTA", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.REGULAR, requisicao.getSituacaoVeiculo());

        Assert.assertEquals(1, consulta.getRequisicoes().size());
        Assert.assertEquals(consulta.getId(), requisicao.getConsulta().getId());
        Assert.assertEquals(detran, requisicao.getFornecedor());
        Assert.assertEquals(detran.getValor(), requisicao.getCustoDaRequisicao());
    }

    @Test
    public void testeConsultaIPVAATRASADO() throws Exception {
        String placa = "BXK-0727";
        Consulta consulta = new Consulta(placa);
        Fornecedor detran = FornecedorDetran.getInstance();
        consulta.criar();
        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);


        Assert.assertEquals("IPVA_ATRASADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaDPVATATRASADO() throws Exception {
        String placa = "BXK-0728";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor detran = FornecedorDetran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("DPVAT_ATRASADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaMULTASPENDENTES() throws Exception {
        String placa = "BXK-0729";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor detran = FornecedorDetran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("MULTAS_PENDENTES", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaLICENCIAMENTOATRASADO() throws Exception {
        String placa = "BXK-0730";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor detran = FornecedorDetran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("LICENCIAMENTO_ATRASADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaVEICULONAOENCONTRADO() throws Exception {
        String placa = "BXK-0732";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor detran = FornecedorDetran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("VEICULO_NAO_ENCONTRADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.REGULAR, requisicao.getSituacaoVeiculo());
    }

    @Test
    public void testeConsultaFURTOPROCURADO() throws Exception {
        String placa = "BXK-0733";
        Consulta consulta = new Consulta(placa);
        consulta.criar();
        Fornecedor detran = FornecedorDetran.getInstance();

        RespostaFornecedor requisicao = consulta.fazerRequisicao(detran);

        Assert.assertEquals("FURTO_PROCURADO", requisicao.getRespostaPura());
        Assert.assertEquals(SituacaoDoVeiculo.IRREGULAR, requisicao.getSituacaoVeiculo());
    }
}
