package com.gsbenevides2.sanduiche;

public class Main {
    private String teste;
    public static void main(String[] args) {
        LauchStore minhaLanchonete = new LauchStore(new SimpleSanduicheFactory());
        Sanduiche meuSanduiche = minhaLanchonete.orderSanduiche("X-Bacon");
        System.out.println("Meu sanduíche: ");
        System.out.println(meuSanduiche);
    }
}