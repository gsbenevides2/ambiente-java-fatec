package com.gsbenevides2.folhaDePagamento;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioAdminstrativoTest {
    @Test
    public void creationalTest() {
        FuncionarioAdminstrativo funcionarioAdminstrativo = new FuncionarioAdminstrativo("123456789", "João", 1200, CargoAdminstrativo.DIRETOR);
        Assert.assertEquals("123456789", funcionarioAdminstrativo.getCPF());
        Assert.assertEquals("João", funcionarioAdminstrativo.getNome());
        Assert.assertEquals(1200, funcionarioAdminstrativo.getSalarioMensal(), 0.01);
        Assert.assertEquals(CargoAdminstrativo.DIRETOR, funcionarioAdminstrativo.getCargo());
        Assert.assertEquals(1200, funcionarioAdminstrativo.calcularSalario(), 0.01);
    }
}
