package org.example;

public class StoreSmallPotato implements PotatoStore {

    @Override
    public Potato orderPotato() {
        return this.createPotato();

    }

    @Override
    public Potato createPotato() {
        Potato potato = new Potato(new SmallPotatoIgredientFactory());
        potato.prepare();
        return potato;
    }


}
