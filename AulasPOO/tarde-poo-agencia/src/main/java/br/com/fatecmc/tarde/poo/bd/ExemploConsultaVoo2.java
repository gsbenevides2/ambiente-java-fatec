package br.com.fatecmc.tarde.poo.bd;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fatecmc.tarde.poo.Voo;

public class ExemploConsultaVoo2 {

	public static void main(String[] args) throws SQLException {

		List<Voo> voos = Voo.consultarTodos();
		String mensagem = "Os voos atualmente cadastrados são:\n";
		for(Voo voo: voos) {
			mensagem +=
					String.format("%d %5s %5s %d R$ %.2f\n", 
							voo.getId(),
							voo.getIataOrigem(),
							voo.getIataDestino(),
							voo.getDuracaoEmHoras(),
							voo.getValorHora());
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
		
	}
	
}
