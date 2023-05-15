package org.example;

public class ArCondicionado implements IObserver{
    @Override
    public void update(Boolean sensorPortaDianteiraEsquerda, Boolean sensorPortaDianteiraDireita, Boolean sensorPortaTraseiraEsquerda, Boolean sensorPortaTraseiraDireita, Boolean sensorPortaMalas, Integer nivelAditivo, Integer temperaturaMotor, Integer temperaturaInterna, Integer barPneuFreteDireito, Integer barPneuFrenteEsquerdo, Integer barPneuTraseiroEsquerdo, Integer barPneuTraseiroDireito, Boolean chuva) {
        if (temperaturaInterna > 30 ) {
            System.out.println("Atenção! A temperatura interna do carro está muito alta! Favor ligar o ar condicionado.");
        }
        if(temperaturaInterna < 20){
            System.out.println("Atenção! A temperatura interna do carro está muito baixa! Favor ligar o ar condicionado.");
        }
    }
}
