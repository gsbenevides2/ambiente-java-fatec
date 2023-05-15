package org.example;

import java.util.Observable;
import java.util.Observer;

public class NivelAditivo implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof CentralVeicular == false) return;

        CentralVeicular centralVeicular = (CentralVeicular) observable;
        Integer nivelAditivo = centralVeicular.getNivelAditivo();
        if (nivelAditivo < 30) {
            System.out.println("Atenção! O nível de aditivo do radiador está baixo! Favor verificar.");
        }
    }
}
