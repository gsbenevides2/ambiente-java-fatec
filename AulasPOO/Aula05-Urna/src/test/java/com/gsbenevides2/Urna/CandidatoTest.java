package com.gsbenevides2.Urna;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {

    @Test
    public void criarCandidato(){
        Partido partido = new Partido("Partido Teste", "123");
        Candidato candidato = new Candidato(Cargo.PREFEITO, "Candidato Teste", "123", partido);

        Assert.assertEquals(Cargo.PREFEITO, candidato.getCargo());
        Assert.assertEquals("Candidato Teste", candidato.getNome());
        Assert.assertEquals("123", candidato.getNumero());
        Assert.assertEquals(partido, candidato.getPartido());
    }

    @Test
    public void criarCandidatoComPartidoDeCodigoDiscrepante(){
        Partido partido = new Partido("Partido Teste", "123");

        IllegalArgumentException throwns = Assert.assertThrows(
            IllegalArgumentException.class,
            () -> new Candidato(Cargo.PREFEITO, "Candidato Teste", "1223", partido)
        );

        Assert.assertEquals("Código do partido discrepante", throwns.getMessage());
    }

    @Test
    public void criarCandidatoComCodigoZero(){
        Partido partido = new Partido("Partido Teste", "123");

        IllegalArgumentException throwns = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> new Candidato(Cargo.PREFEITO, "Candidato Teste", "0000", partido)
        );

        Assert.assertEquals("O número do candidato não pode ser somente 0. Esse é o código para anular o voto.", throwns.getMessage());

    }

}
