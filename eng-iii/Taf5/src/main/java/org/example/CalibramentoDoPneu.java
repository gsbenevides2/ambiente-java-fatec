package org.example;

public class CalibramentoDoPneu implements IObserver{
    @Override
    public void update(Boolean sensorPortaDianteiraEsquerda, Boolean sensorPortaDianteiraDireita, Boolean sensorPortaTraseiraEsquerda, Boolean sensorPortaTraseiraDireita, Boolean sensorPortaMalas, Integer nivelAditivo, Integer temperaturaMotor, Integer temperaturaInterna, Integer barPneuFreteDireito, Integer barPneuFrenteEsquerdo, Integer barPneuTraseiroEsquerdo, Integer barPneuTraseiroDireito, Boolean chuva) {
        if (barPneuFreteDireito < 30 ) {
            System.out.println("Atenção! O pneu dianteiro direito está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuFrenteEsquerdo < 30 ) {
            System.out.println("Atenção! O pneu dianteiro esquerdo está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuTraseiroEsquerdo < 30 ) {
            System.out.println("Atenção! O pneu traseiro esquerdo está com pressão baixa! Favor calibrar pneu.");
        }
        if (barPneuTraseiroDireito < 30 ) {
            System.out.println("Atenção! O pneu traseiro direito está com pressão baixa! Favor calibrar pneu.");
        }

    }
}
