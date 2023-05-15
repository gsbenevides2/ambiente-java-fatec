package org.example;

public class NivelAditivo implements IObserver{
    @Override
    public void update(Boolean sensorPortaDianteiraEsquerda, Boolean sensorPortaDianteiraDireita, Boolean sensorPortaTraseiraEsquerda, Boolean sensorPortaTraseiraDireita, Boolean sensorPortaMalas, Integer nivelAditivo, Integer temperaturaMotor, Integer temperaturaInterna, Integer barPneuFreteDireito, Integer barPneuFrenteEsquerdo, Integer barPneuTraseiroEsquerdo, Integer barPneuTraseiroDireito, Boolean chuva) {
        if (nivelAditivo < 30 ) {
            System.out.println("Atenção! O nível de aditivo do radiador está baixo! Favor verificar.");
        }
    }
}
