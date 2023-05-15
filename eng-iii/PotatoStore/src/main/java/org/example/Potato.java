package org.example;

public class Potato {
    PotatoIngredientFactory ingredientFactory;
    Cheese cheese;
    Sauce sauce;
    Strogonoff strogonoff;

    public Potato(PotatoIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare(){
        cheese = ingredientFactory.createCheese();
        sauce = ingredientFactory.createSauce();
        strogonoff = ingredientFactory.createStrogonoff();
    }

    @Override
    public String toString() {
        return cheese.toString() + ", " + sauce.toString() + " and " +  strogonoff.toString();
    }
}
