package com.gsbenevides2.folhaDePagamento;

public class FuncionarioProfessor extends Funcionario implements IFuncionario{
    private int horasTrabalhadas;
    private double valorHora;
    public FuncionarioProfessor(String CPF, String nome, int horasTrabalhadas, double valorHora) {
        super(CPF, nome);
        setHorasTrabalhadas(horasTrabalhadas);
        setValorHora(valorHora);
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public double getValorHora() {
        return valorHora;
    }
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorHora();
    }
}

