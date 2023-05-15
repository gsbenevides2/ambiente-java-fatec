package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Ingresso;
import br.com.fatecmc.tarde.poo.Voo;

public class ExemploExcluirIngresso {

	public static void main(String[] args) throws SQLException {

		List<Ingresso> ingressos = Ingresso.consultarTodos();

		if(ingressos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há ingressos cadastrados");
			return;
		}

		String mensagem = "Informe o id do ingresso que deseja excluir:\n";
		for(Ingresso ingresso: ingressos) {
			mensagem +=
					String.format("%d %5s R$ %.2f\n",
							ingresso.getId(),
							ingresso.getTituloEvento(),
							ingresso.getValor());
		}

		long id = Long.valueOf(JOptionPane.showInputDialog(mensagem));

		Ingresso ingresso = Ingresso.consultarPorId(id);

		if(ingresso == null) {
			JOptionPane.showMessageDialog(null, "Ingresso não encontrado");
			return;
		}

		ingresso.excluir();

		JOptionPane.showMessageDialog(null, "Ingresso excluído com sucesso!");
	}
	
}
