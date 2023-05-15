package com.gsbenevides2.folhaDePagamento;

public class FuncionarioAdminstrativo extends Funcionario implements IFuncionario{
    private double salarioMensal;
    private CargoAdminstrativo cargo;
    public FuncionarioAdminstrativo(String CPF, String nome, double salarioMensal, CargoAdminstrativo cargo) {
        super(CPF, nome);
        setSalarioMensal(salarioMensal);
        setCargo(cargo);
    }
    public double getSalarioMensal() {
        return salarioMensal;
    }
    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }
    public CargoAdminstrativo getCargo() {
        return cargo;
    }
    public void setCargo(CargoAdminstrativo cargo) {
        this.cargo = cargo;
    }
    public double calcularSalario() {
        return getSalarioMensal();
    }
}
