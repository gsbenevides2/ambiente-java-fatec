package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Voo;

public class ExemploInsercaoVoo2 {

	public static void main(String[] args) throws SQLException {
		
		String iataOrigem = JOptionPane.showInputDialog("Informe a IATA de origem:");
		String iataDestino = JOptionPane.showInputDialog("Informe a IATA de destino:");
		int duracaoEmHoras = Integer.valueOf(JOptionPane.showInputDialog("Informe a duração em horas:"));
		double valorHora = Double.valueOf(JOptionPane.showInputDialog("Informe o valor da hora: "));

		Voo voo = new Voo(iataOrigem, iataDestino, duracaoEmHoras, valorHora);
		voo.salvar();
		
		JOptionPane.showMessageDialog(null, "Voo inserido com sucesso!");
		
	}
	
}
