package org.example;

public class SmallPotatoIgredientFactory implements PotatoIngredientFactory {
    @Override
    public Sauce createSauce() {
        return new WhiteSauce();
    }

    @Override
    public Strogonoff createStrogonoff() {
        return new StrogonoffFlash();
    }

    @Override
    public Cheese createCheese() {
        return new Muzarela();
    }
}
