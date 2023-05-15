package br.com.fatecmc.tarde.poo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Voo implements ItemReservavel {

	// ElephantSQL
//	CREATE TABLE voo(
//			id BIGSERIAL PRIMARY KEY NOT NULL,
//			iata_origem VARCHAR(200) NOT NULL,
//			iata_destino VARCHAR(200) NOT NULL,
//			duracao_em_horas integer NOT NULL,
//			valor_horas double NOT NULL
//			)
	
	private Long id;
	private String iataOrigem;
	private String iataDestino;
	private int duracaoEmHoras;
	private double valorHora;

	public Voo(Long id) {
		setId(id);
	}

	public Voo(String iataOrigem, String iataDestino, int duracaoEmHoras, double valorHora) {
		setIataOrigem(iataOrigem);
		setIataDestino(iataDestino);
		setDuracaoEmHoras(duracaoEmHoras);
		setValorHora(valorHora);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIataOrigem() {
		return iataOrigem;
	}

	public void setIataOrigem(String iataOrigem) {
		this.iataOrigem = iataOrigem;
	}

	public String getIataDestino() {
		return iataDestino;
	}

	public void setIataDestino(String iataDestino) {
		this.iataDestino = iataDestino;
	}

	public int getDuracaoEmHoras() {
		return duracaoEmHoras;
	}

	public void setDuracaoEmHoras(int duracaoEmHoras) {
		this.duracaoEmHoras = duracaoEmHoras;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValor() {
		return duracaoEmHoras * valorHora;
	}

	// Active record
	public void salvar() throws SQLException {
		Connection conexao = Conexao.get();
		
		PreparedStatement sql = conexao.prepareStatement(
				"INSERT INTO voo(iata_origem, iata_destino, duracao_em_horas, valor_horas) " + "VALUES(?, ?, ?, ?)");
		sql.setString(1, iataOrigem);
		sql.setString(2, iataDestino);
		sql.setInt(3, duracaoEmHoras);
		sql.setDouble(4, valorHora);
		sql.execute();

		conexao.close();
	}

	public void excluir() throws SQLException {
		Connection conexao = Conexao.get();
		
		PreparedStatement sql = conexao.prepareStatement("DELETE FROM voo WHERE id=?");
		sql.setLong(1, id);
		sql.execute();

		conexao.close();
	}

	public void alterar() throws SQLException {
		Connection conexao = Conexao.get();
		
		PreparedStatement sql = conexao.prepareStatement("UPDATE voo SET iata_origem=?, " + "iata_destino=?, "
				+ "duracao_em_horas=?, " + "valor_horas=?" + " WHERE id=?");
		sql.setString(1, iataOrigem);
		sql.setString(2, iataDestino);
		sql.setInt(3, duracaoEmHoras);
		sql.setDouble(4, valorHora);
		sql.setLong(5, id);
		sql.execute();

		conexao.close();
	}
	
	public static Voo consultarPorId(long id) throws SQLException {
		Connection conexao = Conexao.get();
		PreparedStatement sql = conexao.prepareStatement(
				  "SELECT * FROM voo WHERE id=?");
		sql.setLong(1, id);
		ResultSet resultado = sql.executeQuery();
		if(resultado.next()) {
			Voo voo = new Voo(
					resultado.getString("iata_origem"),
					resultado.getString("iata_destino"),
					resultado.getInt("duracao_em_horas"),
					resultado.getDouble("valor_horas")
					);
			voo.setId(id);
			conexao.close();
			return voo;
		}
		return null;
	}
	
	public static List<Voo> consultarTodos() throws SQLException {
		Connection conexao = Conexao.get();
		PreparedStatement sql = conexao.prepareStatement(
				  "SELECT * FROM voo");
		ResultSet resultado = sql.executeQuery();
		List<Voo> retorno = new ArrayList<>();
		while(resultado.next()) {
			Voo voo = new Voo(
					resultado.getString("iata_origem"),
					resultado.getString("iata_destino"),
					resultado.getInt("duracao_em_horas"),
					resultado.getDouble("valor_horas")
					);
			voo.setId(resultado.getLong("id"));
			retorno.add(voo);
		}
		conexao.close();
		return retorno;
	}

}
