package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Voo;

public class ExemploExcluirVoo2 {

	public static void main(String[] args) throws SQLException {

		String mensagem = "Informe o id do voo que deseja excluir:\n";
		List<Voo> voos = Voo.consultarTodos();
		for (Voo voo : voos) {
			mensagem += String.format("%d %5s %5s %d R$ %.2f\n", voo.getId(), voo.getIataOrigem(), voo.getIataDestino(),
					voo.getDuracaoEmHoras(), voo.getValorHora());
		}

		long id = Long.valueOf(JOptionPane.showInputDialog(mensagem));

		Voo voo = new Voo(id);
		voo.excluir();

		JOptionPane.showMessageDialog(null, "Voo excluído com sucesso!");

	}

}
