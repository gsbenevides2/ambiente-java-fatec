package org.example;

import java.util.Observable;
import java.util.Observer;

public class LimpadorParaBrisa implements Observer {
    private Boolean ligado = false;
    private Boolean chuva = false;

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof CentralVeicular == false) return;

        CentralVeicular centralVeicular = (CentralVeicular) observable;
        if (chuva != centralVeicular.getChuva()) {

            chuva = centralVeicular.getChuva();
            if (chuva && !ligado) {
                System.out.println("Chuva detectada. Ligando o limpador do para-brisa.");
                ligado = true;
            } else if (!chuva && ligado) {
                System.out.println("Chuva não detectada. Desligando o limpador do para-brisa.");
                ligado = false;
            }
        }
    }
}
