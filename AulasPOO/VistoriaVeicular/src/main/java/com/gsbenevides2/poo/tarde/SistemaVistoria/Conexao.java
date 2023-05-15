package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Conexao {
    public static Connection get() throws SQLException {
		String urlConexao = "jdbc:postgresql://127.0.0.1:5432/veiculos";
		String usuario = "postgres";
		String senha = "12345678";
		return DriverManager.getConnection(urlConexao, usuario, senha);
	}
}
