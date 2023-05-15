package com.gsbenevides2.folhaDePagamento;

public class FolhaDePagamento {
    private IFuncionario funcionario;
    public FolhaDePagamento(IFuncionario funcionario) {
        setFuncionario(funcionario);
    }
    public IFuncionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(IFuncionario funcionario) {
        this.funcionario = funcionario;
    }
    public String toString() {
        String content = "------------------------------------\nFolha de Pagamento\nNome: " + getFuncionario().getNome() + "\nCPF: " + getFuncionario().getCPF() + "\n";
        if (getFuncionario() instanceof FuncionarioProfessor funcionarioProfessor) {
            content += "Cargo: Professor\nHoras Trabalhadas: " + funcionarioProfessor.getHorasTrabalhadas() + "\nValor Hora: R$ " + funcionarioProfessor.getValorHora() + "\n";
        } else if (getFuncionario() instanceof FuncionarioAdminstrativo funcionarioAdminstrativo) {
            content += "Cargo: Administrativo(" + funcionarioAdminstrativo.getCargo() + ")\n";
        }
        content += "Salário: R$ " + getFuncionario().calcularSalario() + "\n------------------------------------";
        return content;
    }
}
