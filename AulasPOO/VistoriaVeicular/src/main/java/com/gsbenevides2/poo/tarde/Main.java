package com.gsbenevides2.poo.tarde;

import com.gsbenevides2.poo.tarde.SistemaVistoria.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
Generate Postgress SQL for tables

CREATE TABLE consultas (
    id BIGSERIAL PRIMARY KEY,
    placa VARCHAR(7) NOT NULL,
    dataEHora TIMESTAMP NOT NULL
);

CREATE TABLE requisicoes (
    id BIGSERIAL PRIMARY KEY,
    idConsulta BIGINT NOT NULL,
    idFornecedor VARCHAR(10) NOT NULL,
    resposta VARCHAR(255) NOT NULL,
    custo NUMERIC(10,2) NOT NULL
);

Use Json Server to create fake API
npx json-server --watch json-server.json

 */

public class Main {
    public static final List<Fornecedor> fornecedores = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        fornecedores.add(FornecedorSenatran.getInstance());
        fornecedores.add(FornecedorDetran.getInstance());

        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de consulta de veículos");
        while (true) {
            showMenu();
        }
    }
    public static void showMenu() throws Exception {
        String message = "Escolha uma opção: ";
        message += "\n1 - Consultar";
        message += "\n2 - Listar Consultas";
        message += "\n3 - Sair";

        String option = JOptionPane.showInputDialog(null, message);

        if (option == null) {
            exit();
        }

        switch (option) {
            case "1":
                showConsultaDialog();
                break;
            case "2":
                showConsultasDialog();
                break;
            case "3":
                exit();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }

    public static void showConsultaDialog() throws Exception {
        String message = "Informe a placa do veículo: ";
        String placa = JOptionPane.showInputDialog(null, message);
        System.out.println(placa);

        Consulta consulta = new Consulta(placa);
        consulta.criar();

        DecimalFormat df = new DecimalFormat("#.00");
        while (true) {
            String message2 = "Temos os seguintes fornecedores disponíveis: ";

            for (int i = 0; i < fornecedores.size(); i++) {
                Fornecedor fornecedor = fornecedores.get(i);
                message2 += "\n" + i + " - " + fornecedor.getNome() +
                        " - " +
                        df.format(fornecedor.getValor()) + " por consulta";
            }
            message2 += "\n\nInforme o número do fornecedor: ";

            String option = JOptionPane.showInputDialog(null, message2);

            if (option == null) {
                break;
            }

            int index = Integer.parseInt(option);

            if (index < 0 || index >= fornecedores.size()) {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                continue;
            }

            Fornecedor fornecedor = fornecedores.get(index);
            RespostaFornecedor res  = consulta.fazerRequisicao(fornecedor);

            String message3 = "O fornecedor " + fornecedor.getNome() + " retornou a seguinte resposta: ";

            if(res.getSituacaoVeiculo() == SituacaoDoVeiculo.REGULAR) {
                message3 += "\nStatus: Carro regular";
            } else {
                message3 += "\nStatus: Carro irregular";
            }
            message3 += "\nResposta: " + res.getRespostaPura();
            message3 += "\n\nCusto dessa consulta: " + df.format(res.getCustoDaRequisicao());
            message3 += "\nCusto total da consulta: " + df.format(consulta.obterTotal());
            message3 += "\n\nDeseja continuar consultando?";

            int option2 = JOptionPane.showConfirmDialog(null, message3);

            if (option2 == JOptionPane.NO_OPTION) {
                break;
            }
        }

        String message4 = "Foram realizadas " + consulta.getRequisicoes().size() + " requisições";
        for(RespostaFornecedor requisicao : consulta.getRequisicoes()) {
            message4 += "\n\nFornecedor: " + requisicao.getFornecedor().getId();
            message4 += "\nResposta: " + requisicao.getSituacaoVeiculo();
            message4 += "\nCusto: " + df.format(requisicao.getCustoDaRequisicao());
        }
        message4 += "\n\nCusto total da consulta: " + df.format(consulta.obterTotal());
        JOptionPane.showMessageDialog(null, message4);
    }

    public static void showConsultasDialog() throws Exception {
        List<Consulta> consultas = Consulta.obterTodas();

        String mensg = "Escolha uma das consultas realizadas para ver os detalhes: ";

        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            String dataFormatda = consulta.getDataEHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            mensg += "\n" + i + " - " + consulta.getPlaca() + " - " + dataFormatda;
        }

        String option = JOptionPane.showInputDialog(null, mensg);

        if (option == null) {
            return;
        }

        int index = Integer.parseInt(option);

        if (index < 0 || index >= consultas.size()) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            return;
        }

        Consulta consulta = consultas.get(index);

        String dataFormatda = consulta.getDataEHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String message = "Consulta realizada em " + dataFormatda + " para a placa " + consulta.getPlaca();
        message += "\n\nFornecedores consultados: ";

        for (RespostaFornecedor requisicao : consulta.getRequisicoes()) {
            message += "\n\nFornecedor: " + requisicao.getFornecedor().getId();
            message += "\nResposta: " + requisicao.getSituacaoVeiculo();
            message += "\nCusto: " + requisicao.getCustoDaRequisicao();
        }

        message += "\n\nCusto total da consulta: " + consulta.obterTotal();

        JOptionPane.showMessageDialog(null, message);
    }

    public static void exit() {
        JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema");
        System.exit(0);
    }

}