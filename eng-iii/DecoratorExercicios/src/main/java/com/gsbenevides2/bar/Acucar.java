package com.gsbenevides2.bar;

public class Acucar extends CoquetelDecorator {
    public Acucar(Coquetel coquetel) {
        super(coquetel);
        nome = "Açúcar";
        preco = 0.5;
    }
}
