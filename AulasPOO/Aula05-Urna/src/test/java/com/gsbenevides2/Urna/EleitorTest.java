package com.gsbenevides2.Urna;

import org.junit.Assert;
import org.junit.Test;

public class EleitorTest {
    @Test
    public void criarEleitor(){
        Eleitor eleitor = new Eleitor("José", "12345678901", "1234");
        Assert.assertEquals("José", eleitor.getNome());
        Assert.assertEquals("12345678901", eleitor.getNumeroDoTitulo());
        Assert.assertEquals("1234", eleitor.getNumeroDaSessao());
    }

    @Test
    public void testarEqualsTrue(){
        Eleitor eleitor1 = new Eleitor("José", "12345678901", "1234");
        Eleitor eleitor2 = new Eleitor("José", "12345678901", "1234");
        Assert.assertEquals(eleitor1.equals(eleitor2), true);
    }

    @Test
    public void testarEqualsFalse(){
        Eleitor eleitor1 = new Eleitor("José", "12345678901", "1234");
        Eleitor eleitor2 = new Eleitor("José", "12345678902", "1234");
        Assert.assertEquals(eleitor1.equals(eleitor2), false);
    }

    @Test
    public void testarEqualsFalseComOutroObjeto(){
        Eleitor eleitor1 = new Eleitor("José", "12345678901", "1234");
        Partido partido = new Partido("Partido do Posto", "22");
        Assert.assertEquals(eleitor1.equals(partido), false);
    }
}
