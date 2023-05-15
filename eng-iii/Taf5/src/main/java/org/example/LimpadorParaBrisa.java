package org.example;

public class LimpadorParaBrisa implements IObserver{
    private Boolean ligado = false;
    private Boolean chuva = false;
    @Override
    public void update(Boolean sensorPortaDianteiraEsquerda, Boolean sensorPortaDianteiraDireita, Boolean sensorPortaTraseiraEsquerda, Boolean sensorPortaTraseiraDireita, Boolean sensorPortaMalas, Integer nivelAditivo, Integer temperaturaMotor, Integer temperaturaInterna, Integer barPneuFreteDireito, Integer barPneuFrenteEsquerdo, Integer barPneuTraseiroEsquerdo, Integer barPneuTraseiroDireito, Boolean chuva) {
        if(chuva != this.chuva) {
            this.chuva = chuva;
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
