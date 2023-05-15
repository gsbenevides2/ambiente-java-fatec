package org.example;

import java.util.Observable;
import java.util.Observer;

public class CalibramentoDoPneu implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof CentralVeicular == false) return;

        CentralVeicular centralVeicular = (CentralVeicular) observable;
        Integer barPneuFreteDireito = centralVeicular.getBarPneuFreteDireito();
        Integer barPneuFrenteEsquerdo = centralVeicular.getBarPneuFrenteEsquerdo();
        Integer barPneuTraseiroEsquerdo = centralVeicular.getBarPneuTraseiroEsquerdo();
        Integer barPneuTraseiroDireito = centralVeicular.getBarPneuTraseiroDireito();

        if (barPneuFreteDireito < 30) {
            System.out.println("Atenção! O pneu dianteiro direito está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuFrenteEsquerdo < 30) {
            System.out.println("Atenção! O pneu dianteiro esquerdo está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuTraseiroEsquerdo < 30) {
            System.out.println("Atenção! O pneu traseiro esquerdo está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuTraseiroDireito < 30) {
            System.out.println("Atenção! O pneu traseiro direito está com pressão baixa! Favor calibrar pneu.");
        }

    }
}
