package com.gsbenevides2.poo.tarde;

public class ServicoAluguelVeicular extends ServicoDeReserva{
    private Veiculo veiculo;
    private int quantidadeDeDias;

    public ServicoAluguelVeicular(Veiculo veiculo, int quantidadeDeDias){
        setVeiculo(veiculo);
        setQuantidadeDeDias(quantidadeDeDias);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public int getQuantidadeDeDias() {
        return quantidadeDeDias;
    }
    private void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    private void setQuantidadeDeDias(int quantidadeDeDias) {
        this.quantidadeDeDias = quantidadeDeDias;
    }

    @Override
    public double getValor() {
        return this.veiculo.getValorDiaria() * this.quantidadeDeDias;
    }
}
