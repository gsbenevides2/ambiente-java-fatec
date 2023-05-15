package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Ingresso;
import br.com.fatecmc.tarde.poo.Voo;

public class ExemploInsercaoIngresso {

    public static void main(String[] args) throws SQLException {


        String tituloDoEvento = JOptionPane.showInputDialog("Informe título do evento:");
        double valor = Double.valueOf(JOptionPane.showInputDialog("Informe o valor do ingresso: "));
        Ingresso ingresso = new Ingresso(tituloDoEvento, valor);
        ingresso.salvar();
        JOptionPane.showMessageDialog(null, "Ingresso inserido com sucesso!");


    }

}
