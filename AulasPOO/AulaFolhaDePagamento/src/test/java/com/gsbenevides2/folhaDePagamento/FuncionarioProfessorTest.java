package com.gsbenevides2.folhaDePagamento;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioProfessorTest {
    @Test
    public void creationalTest() {
        FuncionarioProfessor funcionarioProfessor = new FuncionarioProfessor("123456789", "João", 2000, 1.90);
        Assert.assertEquals("123456789", funcionarioProfessor.getCPF());
        Assert.assertEquals("João", funcionarioProfessor.getNome());
        Assert.assertEquals(2000, funcionarioProfessor.getHorasTrabalhadas(), 0.01);
        Assert.assertEquals(1.90, funcionarioProfessor.getValorHora(), 0.01);
        Assert.assertEquals(3800, funcionarioProfessor.calcularSalario(), 0.01);

    }
}
