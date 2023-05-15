package com.gsbenevides2.folhaDePagamento;

import org.junit.Assert;
import org.junit.Test;

public class FolhaDePagamentoTest {
    @Test
    public void creationalTestForProfessor() {
        FuncionarioProfessor funcionario = new FuncionarioProfessor("123456789", "João", 630, 1.90);
        FolhaDePagamento folhaDePagamento = new FolhaDePagamento(funcionario);
        Assert.assertEquals("------------------------------------\n" +
                "Folha de Pagamento\n" +
                "Nome: João\n" +
                "CPF: 123456789\n" +
                "Cargo: Professor\n" +
                "Horas Trabalhadas: 630\n" +
                "Valor Hora: R$ 1.9\n" +
                "Salário: R$ 1197.0\n" +
                "------------------------------------", folhaDePagamento.toString());
    }

    @Test
    public void creationalTestForAdminstrativo() {
        FuncionarioAdminstrativo funcionario = new FuncionarioAdminstrativo("987654321", "Maria", 1200, CargoAdminstrativo.DIRETOR);
        FolhaDePagamento folhaDePagamento = new FolhaDePagamento(funcionario);
        Assert.assertEquals(
                "------------------------------------\n" +
                        "Folha de Pagamento\n" +
                        "Nome: Maria\n" +
                        "CPF: 987654321\n" +
                        "Cargo: Administrativo(DIRETOR)\n" +
                        "Salário: R$ 1200.0\n" +
                        "------------------------------------"
                , folhaDePagamento.toString());
    }
}
