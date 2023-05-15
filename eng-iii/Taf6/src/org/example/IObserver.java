package org.example;

public interface IObserver {
    public void update(
            Boolean sensorPortaDianteiraEsquerda,
            Boolean sensorPortaDianteiraDireita,
            Boolean sensorPortaTraseiraEsquerda,
            Boolean sensorPortaTraseiraDireita,
            Boolean sensorPortaMalas,
            Integer nivelAditivo,
            Integer temperaturaMotor,
            Integer temperaturaInterna,
            Integer barPneuFreteDireito,
            Integer barPneuFrenteEsquerdo,
            Integer barPneuTraseiroEsquerdo,
            Integer barPneuTraseiroDireito,
            Boolean chuva
    );
}
