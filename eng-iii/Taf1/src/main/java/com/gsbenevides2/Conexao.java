package com.gsbenevides2;
public abstract class Conexao {
	String status;
	
	public abstract void conectar();
	public abstract void desconectar();
	
	public abstract void alterar();
	public abstract void excluir();
	public abstract void incluir();
}
