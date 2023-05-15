package com.gsbenevides2.sanduiche;

public class SimpleSanduicheFactory {
    public Sanduiche createSanduiche(String type){
        Sanduiche sanduiche = null;
        if(type.equals("X-Bacon")){
            sanduiche = new XBacon();
        } else if(type.equals("X-Egg")){
            sanduiche = new XEgg();
        } else if(type.equals("X-Calabresa")){
            sanduiche = new XCalabresa();
        } else if(type.equals("X-Salada")){
            sanduiche = new XSalada();
        }
        return sanduiche;
    }
}
