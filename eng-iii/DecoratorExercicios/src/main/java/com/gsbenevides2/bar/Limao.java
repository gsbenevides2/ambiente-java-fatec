package com.gsbenevides2.bar;

public class Limao extends CoquetelDecorator {
    public Limao(Coquetel coquetel) {
        super(coquetel);
        nome = "Limão";
        preco = 0.5;
    }
}
