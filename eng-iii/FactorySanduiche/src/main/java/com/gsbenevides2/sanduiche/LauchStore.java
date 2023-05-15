package com.gsbenevides2.sanduiche;

public class LauchStore {
    private final SimpleSanduicheFactory factory;
    public LauchStore(SimpleSanduicheFactory factory){
        this.factory = factory;
    }
    public Sanduiche orderSanduiche(String type){
        Sanduiche sanduiche = factory.createSanduiche(type);
        sanduiche.prepare();
        sanduiche.bake();
        sanduiche.cut();
        sanduiche.box();
        return sanduiche;
    }

}
