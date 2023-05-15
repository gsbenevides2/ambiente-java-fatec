package com.gsbenevides2.Urna;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {
    @Test
    public void criarPartido(){
        Partido partido = new Partido("Partido Teste", "123");
        Assert.assertEquals("Partido Teste", partido.getNome());
        Assert.assertEquals("123", partido.getNumero());
    }
}
