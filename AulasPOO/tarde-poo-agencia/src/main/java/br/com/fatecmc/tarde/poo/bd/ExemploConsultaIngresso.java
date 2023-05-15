package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Ingresso;
import br.com.fatecmc.tarde.poo.Voo;

public class ExemploConsultaIngresso {

	public static void main(String[] args) throws SQLException {

		List<Ingresso> ingressos = Ingresso.consultarTodos();

		if(ingressos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há ingressos cadastrados");
			return;
		}

		String mensagem = "Os ingressos atualmente cadastrados são:\n";
		for(Ingresso ingresso: ingressos) {
			mensagem +=
					String.format("%d %5s R$ %.2f\n",
							ingresso.getId(),
							ingresso.getTituloEvento(),
							ingresso.getValor());
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
		
	}
	
}
