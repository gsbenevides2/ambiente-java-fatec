package com.gsbenevides2;
public class Funcionarios extends Conexao implements Cadastros, Endrerecos  {
	@Override
	public String getEndereco() {
		return null;
	}
	@Override
	public void setEndereco(String endereco) {}
	@Override
	public String getCep() {
		return null;
	}
	@Override
	public void setCep(String cep) {}
	@Override
	public String getCidade() {
		return null;
	}
	@Override
	public void setCidade(String cidade) {}
	@Override
	public String getEstado() {
		return null;
	}
	@Override
	public void setEstado(String estado) {}
	@Override
	public String getStatus() {
		return null;
	}
	@Override
	public int getCodigo() {
		return 0;
	}
	@Override
	public void setCodigo(int codigo) {}
	@Override
	public String getNome() {
		return null;
	}
	@Override
	public void setNome(String nome) {}
	@Override
	public void conectar() {}
	@Override
	public void desconectar() {}
	@Override
	public void alterar() {}
	@Override
	public void excluir() {}
	@Override
	public void incluir() {}

}
