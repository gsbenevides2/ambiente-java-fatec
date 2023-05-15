package org.example;

public class BigPotatoIngredient implements PotatoIngredientFactory {
    @Override
    public Sauce createSauce() {
        return new RedSauce();
    }

    @Override
    public Strogonoff createStrogonoff() {
        return new StrogonoffTicken();
    }

    @Override
    public Cheese createCheese() {
        return new Muzarela();
    }
}
