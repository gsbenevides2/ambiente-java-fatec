package com.gsbenevides2.carros;

public class Main {
    public static void main(String[] args) {
        Veiculo meuCarroDeTrabalho = new Palio();
        meuCarroDeTrabalho = new AirBag(meuCarroDeTrabalho);
        meuCarroDeTrabalho = new Multimidia(meuCarroDeTrabalho);
        meuCarroDeTrabalho = new Alarme(meuCarroDeTrabalho);
        System.out.println("Meu carro de trabalho: ");
        exibirCarro(meuCarroDeTrabalho);

        Veiculo meuCarroDePasseio = new Gol();
        meuCarroDePasseio = new AirBag(meuCarroDePasseio);
        meuCarroDePasseio = new Alarme(meuCarroDePasseio);
        meuCarroDePasseio = new Multimidia(meuCarroDePasseio);
        meuCarroDePasseio = new AltoFalante(meuCarroDePasseio);
        System.out.println("Meu carro de passeio: ");
        exibirCarro(meuCarroDePasseio);
    }

    public static void exibirCarro(Veiculo veiculo) {
        System.out.println("Carro: " + veiculo.getNome());
        System.out.println("Preço: " + veiculo.getPreco());
        System.out.println("Descrição: " + veiculo.getDescricao());
    }
}