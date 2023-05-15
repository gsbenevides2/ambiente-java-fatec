package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Ingresso;
import br.com.fatecmc.tarde.poo.Voo;

public class ExemploAlteracaoIngresso {

	public static void main(String[] args) throws SQLException {
		
		String mensagem = "Informe o id do ingresso que deseja alterar:\n";
		List<Ingresso> ingressos = Ingresso.consultarTodos();

		if(ingressos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há ingressos cadastrados!");
			return;
		}

		for (Ingresso ingresso : ingressos) {
			mensagem += String.format("%d %5s R$ %.2f\n", ingresso.getId(), ingresso.getTituloEvento(), ingresso.getValor());
		}

		long id = Long.valueOf(JOptionPane.showInputDialog(mensagem));

		Ingresso ingresso = Ingresso.consultarPorId(id);
		if(ingresso != null) {
			String tituloDoEvento = JOptionPane.showInputDialog("Informe título do evento:", ingresso.getTituloEvento());
			double valor = Double.valueOf(JOptionPane.showInputDialog("Informe o novo valor do ingresso: ", ingresso.getValor()));
			ingresso.setTituloEvento(tituloDoEvento);
			ingresso.setValor(valor);
			ingresso.alterar();
			JOptionPane.showMessageDialog(null, "Ingresso alterado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Ingresso não encontrado!");
		}
		

		
	}
	
}
