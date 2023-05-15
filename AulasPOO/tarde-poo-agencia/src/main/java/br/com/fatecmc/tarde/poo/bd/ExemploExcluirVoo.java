package br.com.fatecmc.tarde.poo.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ExemploExcluirVoo {

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
		
		// SELECT <nomes das colunas> FROM <nome da tabela>
		// WHERE <condições>
		// SELECT * FROM voo WHERE id=1
		PreparedStatement sql = conexao.prepareStatement(
				  "SELECT * FROM voo");
		ResultSet resultado = sql.executeQuery();
		
		// 3: (se tiver retorno)
		// Tratar o retorno
		// inteface ResultSet
		String mensagem = "Informe o id do voo que deseja excluir:\n";
		while(resultado.next()) {
			mensagem +=
					String.format("%d %5s %5s %d R$ %.2f\n", 
							resultado.getInt("id"),
							resultado.getString("iata_origem"),
							resultado.getString("iata_destino"),
							resultado.getInt("duracao_em_horas"),
							resultado.getDouble("valor_horas"));
		}
		
		int id = Integer.valueOf(JOptionPane.showInputDialog(mensagem));
		sql = conexao.prepareStatement(
				"DELETE FROM voo WHERE id=?"
				);
		sql.setInt(1, id);
		sql.execute();
		
		// 4:
		// Liberar a conexão
		// Pode significar: fechar (CUIDADO!)
		// ou dizer que está livre.
		// método de Connection
		conexao.close();
		
		JOptionPane.showMessageDialog(null, "Voo excluído com sucesso!");
		
		
	}
	
}
