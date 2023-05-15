package org.example;

public class BigPotatoStore implements PotatoStore {
    @Override
    public Potato createPotato() {
        Potato potato = new Potato(new BigPotatoIngredient());
        potato.prepare();
        return potato;
    }

    @Override
    public Potato orderPotato() {
        return this.createPotato();
    }
}
