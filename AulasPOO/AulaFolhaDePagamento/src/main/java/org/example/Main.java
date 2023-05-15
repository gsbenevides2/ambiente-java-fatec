package org.example;

import com.gsbenevides2.folhaDePagamento.CargoAdminstrativo;
import com.gsbenevides2.folhaDePagamento.FolhaDePagamento;
import com.gsbenevides2.folhaDePagamento.FuncionarioAdminstrativo;
import com.gsbenevides2.folhaDePagamento.FuncionarioProfessor;

public class Main {
    public static void main(String[] args) {
        FuncionarioProfessor professor = new FuncionarioProfessor("123456789", "João", 630, 1.90);
        FuncionarioAdminstrativo adminstrativo = new FuncionarioAdminstrativo("987654321", "Maria", 1200, CargoAdminstrativo.DIRETOR);
        FolhaDePagamento folhaDePagamentoProfessor = new FolhaDePagamento(professor);
        FolhaDePagamento folhaDePagamentoAdminstrativo = new FolhaDePagamento(adminstrativo);
        System.out.println(folhaDePagamentoProfessor);
        System.out.println(folhaDePagamentoAdminstrativo);
    }
}