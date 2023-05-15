package com.gsbenevides2.poo.tarde.SistemaVistoria;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class ConsultaTest {
    @Test
    public void testePadroesPlaca() {
        HashMap<String, String> placas = new HashMap<>();
        placas.put("AAA-0000", "AAA0A00");
        placas.put("AAA0000", "AAA0A00");
        placas.put("AAA0A00", "AAA0A00");
        placas.put("AAA-0A00", "AAA0A00");
        placas.put("AAA-0100", "AAA0B00");
        placas.put("AAA-0200", "AAA0C00");
        placas.put("AAA-0300", "AAA0D00");
        placas.put("AAA-0400", "AAA0E00");
        placas.put("AAA-0500", "AAA0F00");
        placas.put("AAA-0600", "AAA0G00");
        placas.put("AAA-0700", "AAA0H00");
        placas.put("AAA-0800", "AAA0I00");
        placas.put("AAA-0900", "AAA0J00");
        placas.put("AAA-1000", "AAA1A00");
        placas.put("AAA1100", "AAA1B00");
        placas.put("AAA1200", "AAA1C00");
        placas.put("AAA1300", "AAA1D00");
        placas.put("AAA1400", "AAA1E00");
        placas.put("AAA1500", "AAA1F00");
        placas.put("AAA1600", "AAA1G00");
        placas.put("AAA1700", "AAA1H00");
        placas.put("AAA1800", "AAA1I00");
        placas.put("AAA1900", "AAA1J00");

        for (String placa : placas.keySet()) {
            Consulta consulta = new Consulta(placa);
            Assert.assertEquals(placas.get(placa), consulta.getPlaca());
        }

    }


    // Não esqueça de calcular o Total!
    @Test
    public void testeConsultaVariosFornecedores() throws Exception {
        Consulta consulta = new Consulta("BXK-0731");

        Fornecedor detran = FornecedorDetran.getInstance();
        consulta.criar();
        consulta.fazerRequisicao(detran);
        BigDecimal valorDetran = detran.getValor();
        BigDecimal valorConsulta = consulta.obterTotal();

        Assert.assertTrue(valorConsulta.compareTo(valorDetran) == 0);


    }
}
