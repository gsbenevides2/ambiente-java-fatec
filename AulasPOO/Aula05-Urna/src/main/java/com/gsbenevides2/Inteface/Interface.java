package com.gsbenevides2.Inteface;

import com.gsbenevides2.Urna.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;


public class Interface {

    static Interface instance = null;

    private UrnaEletronica urnaEletronica = new UrnaEletronica("123");

    private Scanner scanner = new Scanner(System.in);

    private Interface() {
        Partido partidoDosProgramadores = new Partido("Partido dos Programadores", "22");
        Partido partidoDosDesigners = new Partido("Partido dos Designers", "33");
        Partido partidoDosTestadores = new Partido("Partido dos Testadores", "44");

        Candidato leandroLuque = new Candidato(Cargo.PREFEITO, "Leandro Luque", "22", partidoDosProgramadores);
        Candidato adrianaValverde = new Candidato(Cargo.PREFEITO, "Adriana Valverde ", "33", partidoDosDesigners);
        Candidato lucianoCarvalho = new Candidato(Cargo.PREFEITO, "Luciano Carvalho", "44", partidoDosTestadores);

        Candidato gilbertoCunha = new Candidato(Cargo.VEREADOR, "Gilberto Cunha", "22", partidoDosProgramadores);
        Candidato fretzJunior = new Candidato(Cargo.VEREADOR, "Fretz Junior", "33", partidoDosDesigners);
        Candidato fabioCodo = new Candidato(Cargo.VEREADOR, "Fábio Codo", "44", partidoDosTestadores);

        Eleitor antonioWellington = new Eleitor("Antonio Wellington", "0001", "123");
        Eleitor brunoPanccioni = new Eleitor("Bruno Panccioni", "0002", "123");
        Eleitor carlaAguiar = new Eleitor("Carla Aguiar", "0003", "123");
        Eleitor edsonLeal = new Eleitor("Edson Leal", "0004", "123");
        Eleitor eliasRibeiro = new Eleitor("Elias Ribeiro", "0005", "123");
        Eleitor josimeireMartins = new Eleitor("Josimeire Martins", "0006", "123");
        Eleitor marcosMihara = new Eleitor("Marcos Mihara", "0007", "123");
        Eleitor mariaPinedo = new Eleitor("Maria Pinedo", "0008", "123");
        Eleitor mariangelaMolina = new Eleitor("Mariangela Molina", "0009", "123");
        Eleitor pedroJunior = new Eleitor("Pedro Junior", "0010", "123");

        urnaEletronica.cadastrarCandidato(leandroLuque);
        urnaEletronica.cadastrarCandidato(adrianaValverde);
        urnaEletronica.cadastrarCandidato(lucianoCarvalho);
        urnaEletronica.cadastrarCandidato(gilbertoCunha);
        urnaEletronica.cadastrarCandidato(fretzJunior);
        urnaEletronica.cadastrarCandidato(fabioCodo);

        urnaEletronica.cadastrarEleitor(antonioWellington);
        urnaEletronica.cadastrarEleitor(brunoPanccioni);
        urnaEletronica.cadastrarEleitor(carlaAguiar);
        urnaEletronica.cadastrarEleitor(edsonLeal);
        urnaEletronica.cadastrarEleitor(eliasRibeiro);
        urnaEletronica.cadastrarEleitor(josimeireMartins);
        urnaEletronica.cadastrarEleitor(marcosMihara);
        urnaEletronica.cadastrarEleitor(mariaPinedo);
        urnaEletronica.cadastrarEleitor(mariangelaMolina);
        urnaEletronica.cadastrarEleitor(pedroJunior);

    }

    public static Interface getInstance() {
        if (instance == null) {
            instance = new Interface();
        }
        return instance;
    }

    public void iniciar() {
        System.out.println("Bem vindo a Urna Eletrônica - TSE (Tribunal Superior Eleitoral) - Sessão: " + urnaEletronica.getSessao());
        System.out.println("Por questões de segurança, a zeresima será impressa! Verfique se a zeresima está correta!");
        System.out.println("----------------------------------------");
        this.imprimirZeresima();
        System.out.println("----------------------------------------");
        System.out.print("A zeresima está correta? (S/N) ");
        // Use Scanner
        String resposta = scanner.nextLine();
        // Refactor the code to use return early
        if(resposta.equalsIgnoreCase("N")){
            System.out.println("A zeresima não está correta! Por favor, reinicie o sistema!");
            return;
        }
        System.out.println("Iniciando a votação!");
        System.out.println("----------------------------------------");
        this.iniciarVotacao();
        System.out.println("----------------------------------------");
        System.out.println("A votação foi encerrada!");
        System.out.println("Imprimindo o resultado da votação!");
        this.imprimirZeresima();
    }

    private void imprimirZeresima() {
        System.out.println("Urna Eletrônica - TSE (Tribunal Superior Eleitoral) - Zeresima");
        System.out.println("Sessão: " + urnaEletronica.getSessao() + "\t\t\t\tData: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy" + " - " + "HH:mm:ss")));

        System.out.println("Votos para Prefeito");
        String format = "%-4s %-20s %-30s %-4s";
        HashMap<Candidato, Integer> votosPrefeito = urnaEletronica.obterResultado(Cargo.PREFEITO);
        for (Candidato candidato : votosPrefeito.keySet()) {
            System.out.println(String.format(format, candidato.getNumero(), candidato.getNome(), candidato.getPartido().getNome(), votosPrefeito.get(candidato)));
        }
        long totalVotosBrancosPrefeito = urnaEletronica.contarVotosBrancos(Cargo.PREFEITO);
        long totalVotosNulosPrefeito = urnaEletronica.contarVotosNulos(Cargo.PREFEITO);
        Integer totalVotosPrefeito = votosPrefeito.values().stream().mapToInt(Integer::intValue).sum();
        String newFormat = "%-56s %-4s";
        System.out.println(String.format(newFormat, "Votos Brancos: ", totalVotosBrancosPrefeito));
        System.out.println(String.format(newFormat, "Votos Nulos: ", totalVotosNulosPrefeito));
        System.out.println(String.format(newFormat, "Total de Votos: ", totalVotosBrancosPrefeito + totalVotosNulosPrefeito + totalVotosPrefeito));

        HashMap<Candidato, Integer> votosVereador = urnaEletronica.obterResultado(Cargo.VEREADOR);
        System.out.println("Votos para Vereador");
        for (Candidato candidato : votosVereador.keySet()) {
            System.out.println(String.format(format, candidato.getNumero(), candidato.getNome(), candidato.getPartido().getNome(), votosVereador.get(candidato)));
        }
        long totalVotosBrancosVereador = urnaEletronica.contarVotosBrancos(Cargo.VEREADOR);
        long totalVotosNulosVereador = urnaEletronica.contarVotosNulos(Cargo.VEREADOR);
        Integer totalVotosVereador = votosVereador.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(String.format(newFormat, "Votos Brancos: ", totalVotosBrancosVereador));
        System.out.println(String.format(newFormat, "Votos Nulos: ", totalVotosNulosVereador));
        System.out.println(String.format(newFormat, "Total de Votos: ", totalVotosBrancosVereador + totalVotosNulosVereador + totalVotosVereador));

        System.out.println("Fim da Zeresima");
    }

    private void iniciarVotacao() {
        while(true){
            Eleitor eleitorVotando = this.identificarEleitor();
            System.out.println("Olá " + eleitorVotando.getNome() + " Seja Bem-vindo!");
            if(urnaEletronica.eleitorJaVotouParaCargo(eleitorVotando.getNumeroDoTitulo(), Cargo.PREFEITO)){
                System.out.println("Você já votou para Prefeito!");
            } else {
                this.votar(eleitorVotando.getNumeroDoTitulo(), Cargo.PREFEITO);
            }
            if(urnaEletronica.eleitorJaVotouParaCargo(eleitorVotando.getNumeroDoTitulo(), Cargo.VEREADOR)){
                System.out.println("Você já votou para Vereador!");
            } else {
                this.votar(eleitorVotando.getNumeroDoTitulo(), Cargo.VEREADOR);
            }
            System.out.println("Obrigado por votar! Justiça Eleitoral!");
            System.out.println("----------------------------------------");
            System.out.print("Deseja votar novamente? (S/N) ");
            // Use Scanner
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Encerrando a votação!");
                System.out.println("----------------------------------------");
                break;
            }
        }
    }

    private Eleitor identificarEleitor(){
        System.out.print("Digite o Número do seu Título de Eleitor: ");
        String numeroTitulo = scanner.nextLine();
        Optional<Eleitor> eleitor = urnaEletronica.obterEleitor(numeroTitulo);
        if (!eleitor.isPresent()) {
            System.out.println("Erro: Eleitor não cadastrado!");
            return this.identificarEleitor();
        }
        Eleitor eleitorVotando = eleitor.get();
        return eleitorVotando;
    }

    private void votar(String numeroDoTitulo, Cargo cargo) {
        String cargoString = cargo == Cargo.PREFEITO ? "PREFEITO" : "VEREADOR";
        while (true) {
            System.out.print("Digite o número do candidato que deseja votar para " + cargoString + ": ");
            String numeroCandidato = scanner.nextLine();
            if (numeroCandidato.length() == 0) {
                System.out.println("Você vai votar em BRANCO!");
                System.out.print("Confirma? (S/N) ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("N")) {
                    System.out.println("Voto em BRANCO cancelado!");
                    continue;
                }
                urnaEletronica.votar(numeroDoTitulo, "", cargo);
                System.out.println("Voto em BRANCO computado com sucesso!");
                break;
            }
            if (numeroCandidato.length() != 2) {
                System.out.println("Erro: Número do candidato inválido!");
                continue;
            }
            Optional<Candidato> candidato = urnaEletronica.getCandidatoPorNumero(numeroCandidato, cargo);
            if (!candidato.isPresent()) {
                System.out.println("Você vai votar em NULO!");
                System.out.print("Confirma? (S/N) ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("N")) {
                    System.out.println("Voto NULO cancelado!");
                    continue;
                }
                urnaEletronica.votar(numeroDoTitulo, "", cargo);
                System.out.println("Voto NULO computado com sucesso!");
                break;
            }
            System.out.println("Você vai votar no candidato " + candidato.get().getNome() + " do partido " + candidato.get().getPartido().getNome());
            System.out.print("Confirma? (S/N) ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Voto cancelado!");
                continue;
            }
            urnaEletronica.votar(numeroDoTitulo, numeroCandidato, cargo);
            System.out.println("Voto computado com sucesso!");
            break;
        }

    }

}
