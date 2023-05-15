package org.example;

import java.util.ArrayList;
import java.util.List;

public class CentralVeicular implements ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private Boolean sensorPortaDianteiraEsquerda = false;
    private Boolean sensorPortaDianteiraDireita = false;
    private Boolean sensorPortaTraseiraEsquerda = false;
    private Boolean sensorPortaTraseiraDireita = false;
    private Boolean sensorPortaMalas = false;
    private Integer nivelAditivo = 0;
    private Integer temperaturaMotor = 0;
    private Integer temperaturaInterna = 0;
    private Integer barPneuFreteDireito = 0;
    private Integer barPneuFrenteEsquerdo = 0;
    private Integer barPneuTraseiroEsquerdo = 0;
    private Integer barPneuTraseiroDireito = 0;
    private Boolean chuva = false;

    public CentralVeicular(Boolean sensorPortaDianteiraEsquerda,
                           Boolean sensorPortaDianteiraDireita,
                           Boolean sensorPortaTraseiraEsquerda,
                           Boolean sensorPortaTraseiraDireita,
                           Boolean sensorPortaMalas,
                           Integer nivelAditivo,
                           Integer temperaturaInterna,
                           Integer temperaturaMotor,
                           Integer barPneuFreteDireito,
                           Integer barPneuFrenteEsquerdo,
                           Integer barPneuTraseiroEsquerdo,
                           Integer barPneuTraseiroDireito,
                           Boolean chuva) {
        this.sensorPortaDianteiraEsquerda = sensorPortaDianteiraEsquerda;
        this.sensorPortaDianteiraDireita = sensorPortaDianteiraDireita;
        this.sensorPortaTraseiraEsquerda = sensorPortaTraseiraEsquerda;
        this.sensorPortaTraseiraDireita = sensorPortaTraseiraDireita;
        this.sensorPortaMalas = sensorPortaMalas;
        this.nivelAditivo = nivelAditivo;
        this.temperaturaInterna = temperaturaInterna;
        this.temperaturaMotor = temperaturaMotor;
        this.barPneuFreteDireito = barPneuFreteDireito;
        this.barPneuFrenteEsquerdo = barPneuFrenteEsquerdo;
        this.barPneuTraseiroEsquerdo = barPneuTraseiroEsquerdo;
        this.barPneuTraseiroDireito = barPneuTraseiroDireito;
        this.chuva = chuva;
    }


    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this.sensorPortaDianteiraEsquerda,
                    this.sensorPortaDianteiraDireita,
                    this.sensorPortaTraseiraEsquerda,
                    this.sensorPortaTraseiraDireita,
                    this.sensorPortaMalas,
                    this.nivelAditivo,
                    this.temperaturaMotor,
                    this.temperaturaInterna,
                    this.barPneuFreteDireito,
                    this.barPneuFrenteEsquerdo,
                    this.barPneuTraseiroEsquerdo,
                    this.barPneuTraseiroDireito,
                    this.chuva
            );
        }
    }

    public void setSensorPortaDianteiraEsquerda(Boolean sensorPortaDianteiraEsquerda) {
        this.sensorPortaDianteiraEsquerda = sensorPortaDianteiraEsquerda;
        this.notifyObservers();
    }

    public void setSensorPortaDianteiraDireita(Boolean sensorPortaDianteiraDireita) {
        this.sensorPortaDianteiraDireita = sensorPortaDianteiraDireita;
        this.notifyObservers();
    }

    public void setSensorPortaTraseiraEsquerda(Boolean sensorPortaTraseiraEsquerda) {
        this.sensorPortaTraseiraEsquerda = sensorPortaTraseiraEsquerda;
        this.notifyObservers();
    }

    public void setSensorPortaTraseiraDireita(Boolean sensorPortaTraseiraDireita) {
        this.sensorPortaTraseiraDireita = sensorPortaTraseiraDireita;
        this.notifyObservers();
    }

    public void setSensorPortaMalas(Boolean sensorPortaMalas) {
        this.sensorPortaMalas = sensorPortaMalas;
        this.notifyObservers();
    }

    public void setNivelAditivo(Integer nivelAditivo) {
        this.nivelAditivo = nivelAditivo;
        this.notifyObservers();
    }

    public void setTemperaturaMotor(Integer temperaturaMotor) {
        this.temperaturaMotor = temperaturaMotor;
        this.notifyObservers();
    }

    public void setTemperaturaInterna(Integer temperaturaInterna) {
        this.temperaturaInterna = temperaturaInterna;
        this.notifyObservers();
    }

    public void setBarPneuFreteDireito(Integer barPneuFreteDireito) {
        this.barPneuFreteDireito = barPneuFreteDireito;
        this.notifyObservers();
    }

    public void setBarPneuFrenteEsquerdo(Integer barPneuFrenteEsquerdo) {
        this.barPneuFrenteEsquerdo = barPneuFrenteEsquerdo;
        this.notifyObservers();
    }

    public void setBarPneuTraseiroEsquerdo(Integer barPneuTraseiroEsquerdo) {
        this.barPneuTraseiroEsquerdo = barPneuTraseiroEsquerdo;
        this.notifyObservers();
    }

    public void setBarPneuTraseiroDireito(Integer barPneuTraseiroDireito) {
        this.barPneuTraseiroDireito = barPneuTraseiroDireito;
        this.notifyObservers();
    }

    public void setChuva(Boolean chuva) {
        this.chuva = chuva;
        this.notifyObservers();
    }
}
