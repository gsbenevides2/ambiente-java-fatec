package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Desta vez usando observable do Proprio Java");

        CentralVeicular centralVeicular = new CentralVeicular(
                false,
                false,
                false,
                false,
                false,
                40,
                25,
                40,
                40,
                40,
                40,
                40,
                false
        );

        centralVeicular.addObserver(new Alarme());
        centralVeicular.addObserver(new NivelAditivo());
        centralVeicular.addObserver(new ArCondicionado());
        centralVeicular.addObserver(new CalibramentoDoPneu());
        centralVeicular.addObserver(new LimpadorParaBrisa());

        System.out.println("Abrindo a porta dianteira esquerda");
        centralVeicular.setSensorPortaDianteiraEsquerda(true);
        System.out.println("Fechando a porta dianteira esquerda");
        centralVeicular.setSensorPortaDianteiraEsquerda(false);

        System.out.println("Começou a chover");
        centralVeicular.setChuva(true);
        System.out.println("Parou de chover");
        centralVeicular.setChuva(false);

        System.out.println("Aumentando a temperatura do motor");
        centralVeicular.setTemperaturaMotor(100);
        System.out.println("Diminuindo a temperatura do motor");
        centralVeicular.setTemperaturaMotor(25);

        System.out.println("Aumentando a temperatura interna");
        centralVeicular.setTemperaturaInterna(100);
        System.out.println("Diminuindo a temperatura interna");
        centralVeicular.setTemperaturaInterna(10);
        System.out.println("Reestabelecendo a temperatura interna");
        centralVeicular.setTemperaturaInterna(25);

        System.out.println("Diminuindo o nível do aditivo");
        centralVeicular.setNivelAditivo(20);
        System.out.println("Restabelecendo o nível do aditivo");
        centralVeicular.setNivelAditivo(40);

        System.out.println("Diminuindo a pressão do pneu");
        centralVeicular.setBarPneuFrenteEsquerdo(20);
        System.out.println("Enchendo o Pneu");
        centralVeicular.setBarPneuFrenteEsquerdo(40);
    }
}