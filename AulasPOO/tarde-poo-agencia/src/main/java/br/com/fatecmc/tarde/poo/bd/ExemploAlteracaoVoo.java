package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Voo;

public class ExemploAlteracaoVoo {

	public static void main(String[] args) throws SQLException {
		
		String mensagem = "Informe o id do voo que deseja alterar:\n";
		List<Voo> voos = Voo.consultarTodos();
		for (Voo voo : voos) {
			mensagem += String.format("%d %5s %5s %d R$ %.2f\n", voo.getId(), voo.getIataOrigem(), voo.getIataDestino(),
					voo.getDuracaoEmHoras(), voo.getValorHora());
		}

		long id = Long.valueOf(JOptionPane.showInputDialog(mensagem));

		Voo voo = Voo.consultarPorId(id);
		if(voo != null) {
			String iataOrigem = JOptionPane.showInputDialog("Informe a nova IATA de origem:", voo.getIataOrigem());
			String iataDestino = JOptionPane.showInputDialog("Informe a nova IATA de destino:", voo.getIataDestino());
			int duracaoEmHoras = Integer.valueOf(JOptionPane.showInputDialog("Informe a nova duração em horas:", voo.getDuracaoEmHoras()));
			double valorHora = Double.valueOf(JOptionPane.showInputDialog("Informe o novo valor da hora: ", voo.getValorHora()));

			voo.setIataOrigem(iataOrigem);
			voo.setIataDestino(iataDestino);
			voo.setDuracaoEmHoras(duracaoEmHoras);
			voo.setValorHora(valorHora);
			voo.alterar();
		}
		
		JOptionPane.showMessageDialog(null, "Voo atualizado com sucesso!");
		
		
	}
	
}
