package org.example;

import java.util.Observable;
import java.util.Observer;

public class Alarme implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof CentralVeicular == false) return;

        CentralVeicular centralVeicular = (CentralVeicular) observable;

        Boolean sensorPortaTraseiraEsquerda = centralVeicular.getSensorPortaTraseiraEsquerda();
        Boolean sensorPortaTraseiraDireita = centralVeicular.getSensorPortaTraseiraDireita();
        Boolean sensorPortaDianteiraEsquerda = centralVeicular.getSensorPortaDianteiraEsquerda();
        Boolean sensorPortaDianteiraDireita = centralVeicular.getSensorPortaDianteiraDireita();
        Boolean sensorPortaMalas = centralVeicular.getSensorPortaMalas();


        if (sensorPortaDianteiraEsquerda) {
            System.out.println("Atenção! A porta dianteira esquerda está aberta! Favor fechá-la. ");
        }
        if (sensorPortaDianteiraDireita) {
            System.out.println("Atenção! A porta dianteira direita está aberta! Favor fechá-la. ");
        }
        if (sensorPortaTraseiraEsquerda) {
            System.out.println("Atenção! A porta traseira esquerda está aberta! Favor fechá-la. ");
        }
        if (sensorPortaTraseiraDireita) {
            System.out.println("Atenção! A porta traseira direita está aberta! Favor fechá-la. ");
        }
        if (sensorPortaMalas) {
            System.out.println("Atenção! A porta do malas está aberta! Favor fechá-la. ");
        }
    }

}
