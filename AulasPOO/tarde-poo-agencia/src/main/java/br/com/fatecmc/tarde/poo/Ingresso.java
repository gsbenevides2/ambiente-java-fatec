package br.com.fatecmc.tarde.poo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ingresso implements ItemReservavel {
	/*
	CREATE TABLE ingresso (
    	id BIGSERIAL 	PRIMARY KEY NOT NULL,
    	titulo_evento 	VARCHAR(200) NOT NULL,
    	valor 			DOUBLE_PRECISION NOT NULL
	);
	 */
	private Long id;
	private String tituloEvento;
	private double valor;
	
	public Ingresso(String tituloEvento, double valor) {
		setTituloEvento(tituloEvento);
		setValor(valor);
	}

	public String getTituloEvento() {
		return tituloEvento;
	}

	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	// Active record

	public void salvar() throws SQLException {
		Connection conexao = Conexao.get();

		PreparedStatement sql = conexao.prepareStatement(
				"INSERT INTO ingresso(titulo_evento, valor) VALUES(?,?)"
		);
		sql.setString(1, tituloEvento);
		sql.setDouble(2, valor);
		sql.execute();

		conexao.close();
	}

	public void excluir() throws SQLException {
		Connection conexao = Conexao.get();

		PreparedStatement sql = conexao.prepareStatement(
				"DELETE FROM ingresso WHERE id = ?"
		);
		sql.setLong(1, id);
		sql.execute();

		conexao.close();
	}

	public void alterar() throws SQLException {
		Connection conexao = Conexao.get();

		PreparedStatement sql = conexao.prepareStatement(
				"UPDATE ingresso SET titulo_evento = ?, valor = ? WHERE id = ?"
		);
		sql.setString(1, tituloEvento);
		sql.setDouble(2, valor);
		sql.setLong(3, id);
		sql.execute();

		conexao.close();
	}

	public static Ingresso consultarPorId(long id) throws SQLException {
		Connection conexao = Conexao.get();
		PreparedStatement sql = conexao.prepareStatement(
				"SELECT * FROM ingresso WHERE id = ?"
		);
		sql.setLong(1, id);
		ResultSet resultado = sql.executeQuery();

		Ingresso ingresso = null;

		if (resultado.next()) {
			ingresso = new Ingresso(
					resultado.getString("titulo_evento"),
					resultado.getDouble("valor")
			);
			ingresso.setId(resultado.getLong("id"));
		}

		conexao.close();

		return ingresso;
	}

	public static List<Ingresso> consultarTodos() throws SQLException {
		Connection conexao = Conexao.get();
		PreparedStatement sql = conexao.prepareStatement(
				"SELECT * FROM ingresso"
		);
		ResultSet resultado = sql.executeQuery();

		List<Ingresso> ingressos = new ArrayList<Ingresso>();

		while (resultado.next()) {
			Ingresso ingresso = new Ingresso(
					resultado.getString("titulo_evento"),
					resultado.getDouble("valor")
			);
			ingresso.setId(resultado.getLong("id"));
			ingressos.add(ingresso);
		}

		conexao.close();

		return ingressos;
	}
}
