package com.gsbenevides2.poo.tarde.db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExemploSelecaoVoo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://127.0.0.1:5432/agencia";
        Connection conexao = DriverManager.getConnection(url, "postgres", "12345678");

        PreparedStatement sql = conexao.prepareStatement("SELECT * FROM voo");

        ResultSet resultado = sql.executeQuery();
        String mensagem = "Os voos atualmente cadastrados são:\n";
        while (resultado.next() == true){
            mensagem += String.format(
                    "%d %5s %5s %d R$ %.2f\n",
                    resultado.getInt("id"),
                    resultado.getString("iata_origem"),
                    resultado.getString("iata_destino"),
                    resultado.getInt("duracao_em_horas"),
                    resultado.getDouble("valor_horas")
            );
        }

        conexao.close();

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
