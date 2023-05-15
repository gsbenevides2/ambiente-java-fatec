package org.example;

import java.util.Observable;
import java.util.Observer;

public class ArCondicionado implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof CentralVeicular == false) return;

        CentralVeicular centralVeicular = (CentralVeicular) observable;
        Integer temperaturaInterna = centralVeicular.getTemperaturaInterna();
        if (temperaturaInterna > 30) {
            System.out.println("Atenção! A temperatura interna do carro está muito alta! Favor ligar o ar condicionado.");
        }
        if (temperaturaInterna < 20) {
            System.out.println("Atenção! A temperatura interna do carro está muito baixa! Favor ligar o ar condicionado.");
        }
    }
}
