package br.com.fatecmc.tarde.poo.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ExemploInsercaoVoo {

	public static void main(String[] args) throws SQLException {
		
		// Assumindo que o esquema do banco já esteja
		// criado.
		
		// 1:
		// Obter uma conexão
		// Pode significar: abrir ou
		// reaproveitar uma aberta
		// classe DriverManager, interface Connection
		String urlConexao = "jdbc:postgresql://127.0.0.1:5432/agencia";
		String usuario = "postgres";
		String senha = "123Fatec";
		Connection conexao;
		conexao = DriverManager.getConnection(urlConexao, usuario, senha);
		
		// 2:
		// Executar instruções SQL
		// Ex: INSERT, UPDATE, DELETE, SELECT etc.
		// interfaces PreparedStatement (PREFERENCIALMENTE) ou
		// Statement (EVITE USAR)
		String iataOrigem = JOptionPane.showInputDialog("Informe a IATA de origem:");
		String iataDestino = JOptionPane.showInputDialog("Informe a IATA de destino:");
		int duracaoEmHoras = Integer.valueOf(JOptionPane.showInputDialog("Informe a duração em horas:"));
		double valorHora = Double.valueOf(JOptionPane.showInputDialog("Informe o valor da hora: "));
		
		// INSERT INTO <nome da tabela>(<coluna 1>, <coluna 2> ,...)
		// VALUES(<valor da coluna 1>, <valor da coluna 2> ,...);
		PreparedStatement sql = conexao.prepareStatement(
				  "INSERT INTO voo(iata_origem, iata_destino, duracao_em_horas, valor_horas) "
				+ "VALUES(?, ?, ?, ?)");
		sql.setString(1, iataOrigem);
		sql.setString(2, iataDestino);
		sql.setInt(3, duracaoEmHoras);
		sql.setDouble(4, valorHora);
		sql.execute();
		
		// 3: (se tiver retorno)
		// Tratar o retorno
		// inteface ResultSet
		
		// 4:
		// Liberar a conexão
		// Pode significar: fechar (CUIDADO!)
		// ou dizer que está livre.
		// método de Connection
		conexao.close();
		
		JOptionPane.showMessageDialog(null, "Voo inserido com sucesso!");
		
	}
	
}
