package com.gsbenevides2.bar;

public class Suco extends CoquetelDecorator{
    public Suco(Coquetel coquetel) {
        super(coquetel);
        nome = "Suco";
        preco = 2.5;
    }
}
