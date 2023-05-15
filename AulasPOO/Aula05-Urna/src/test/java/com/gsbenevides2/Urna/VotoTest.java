package com.gsbenevides2.Urna;

import org.junit.Assert;
import org.junit.Test;

public class VotoTest {
    @Test
    public void criarVoto(){
        Partido partido = new Partido("Partido dos Perdedores", "23");
        Candidato candidato = new Candidato(Cargo.PREFEITO, "Armando da Costa", "23",partido );
        VotoCandidato vot = new VotoCandidato(candidato);

        Assert.assertEquals(vot.getCandidato(), candidato);
    }
}
