package org.example;

public class Alarme implements IObserver {
    @Override
    public void update(Boolean sensorPortaDianteiraEsquerda, Boolean sensorPortaDianteiraDireita, Boolean sensorPortaTraseiraEsquerda, Boolean sensorPortaTraseiraDireita, Boolean sensorPortaMalas, Integer nivelAditivo, Integer temperaturaMotor, Integer temperaturaInterna, Integer barPneuFreteDireito, Integer barPneuFrenteEsquerdo, Integer barPneuTraseiroEsquerdo, Integer barPneuTraseiroDireito, Boolean chuva) {
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
