package com.gsbenevides2.poo.tarde.db;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExemploInsercaoVoo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://127.0.0.1:5432/agencia";
        Connection conexao = DriverManager.getConnection(url, "postgres", "12345678");

        String iataOrigem = JOptionPane.showInputDialog("Informe a IATA de Origem:");
        String iataDestino = JOptionPane.showInputDialog("Informe a IATA de Destino:");
        int duracaoEmHoras = Integer.valueOf(JOptionPane.showInputDialog("Quantas Horas a duração do voo:"));
        double valorHora = Double.valueOf(JOptionPane.showInputDialog("Qual o valor hora"));

        PreparedStatement sql = conexao.prepareStatement(
                "INSERT INTO voo(iata_origem, iata_destino, duracao_em_horas, valor_horas) VALUES(?,?,?,?)"
        );
        sql.setString(1, iataOrigem);
        sql.setString(2, iataDestino);
        sql.setInt(3, duracaoEmHoras);
        sql.setDouble(4, valorHora);

        sql.execute();

        conexao.close();

        JOptionPane.showMessageDialog(null, "Tudo feito com sucesso!");
    }
}
