package com.gsbenevides2.folhaDePagamento;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTest {
    @Test
    public void creationalTest() {
        Funcionario funcionario = new Funcionario("123456789", "João");
        Assert.assertEquals("123456789", funcionario.getCPF());
        Assert.assertEquals("João", funcionario.getNome());
    }
}
