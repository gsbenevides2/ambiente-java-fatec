package com.gsbenevides2.poo.tarde.SistemaVistoria;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private Long id;

    private final List<RespostaFornecedor> requisicoes = new ArrayList<>();
    private LocalDateTime dataEHora;
    private String placa;

    public Consulta(String placa) {
        setPlaca(placa);
        setDataEHora(LocalDateTime.now());
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private void setDataEHora(LocalDateTime dataEHora) {
        if (dataEHora == null) throw new IllegalArgumentException("Data e Hora não podem ser nulos!");
        this.dataEHora = dataEHora;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    private void setPlaca(String placa) {
        if (placa == null) throw new IllegalArgumentException("A placa não pode ser nula!");
        placa = placa.trim().toUpperCase();
        if (placa.isEmpty()) throw new IllegalArgumentException("A placa não pode ser vazia!");
        if (placa.length() < 7 || placa.length() > 8)
            throw new IllegalArgumentException("A placa precisa ter somente 7 ou 8 characteres!");
        String regex = "[A-Z]{3}[-]?[0-9][0-9A-Z][0-9]{2}";
        // Validar a placa com o padrão acima
        if (!placa.matches(regex))
            throw new IllegalArgumentException("A placa não está no padrão correto! Padrões Válidos: AAA-0000, AAA0000 e AAA0A00");
        // Padronizar a placa para AAA0A00
        if (placa.length() == 8) {
            placa = placa.substring(0, 3) + placa.substring(4, 8);
        }
        // Caso o padrão seja AAA0000 padronizar para AAA0A00
        if (placa.substring(4, 5).matches("[0-9]")) {
            String[] letras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            String firstPart = placa.substring(0, 4);
            String secondPart = placa.substring(4, 5);
            String thirdPart = placa.substring(5, 7);
            placa = firstPart + letras[Integer.parseInt(secondPart)] + thirdPart;
        }
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public RespostaFornecedor fazerRequisicao(Fornecedor fornecedor) throws Exception {
        if (fornecedor == null) throw new IllegalArgumentException("O fornecedor não pode ser nulo!");
        if (!(fornecedor instanceof FornecedorPrivado)) throw new IllegalArgumentException("O fornecedor não é válido!");
        RespostaFornecedor requisicao = ((FornecedorPrivado) fornecedor).fazerRequisicao(this);
        salvarRequisicao(requisicao);
        requisicoes.add(requisicao);
        return requisicao;
    }


    public List<RespostaFornecedor> getRequisicoes() {
        return requisicoes;
    }

    public BigDecimal obterTotal() {
        BigDecimal valor = requisicoes.stream()
                .reduce(
                        BigDecimal.ZERO,
                        (subtotal, requisicao) -> subtotal.add(requisicao.getCustoDaRequisicao()),
                        BigDecimal::add
                );
        return valor;
    }

    // Active Record

    public void criar() throws Exception {
        Connection conexao = Conexao.get();
        String sql = "INSERT INTO consultas (placa, dataEHora) VALUES (?, ?)";
        PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        comando.setString(1, getPlaca());
        comando.setObject(2, getDataEHora());
        // Obtenha o id da consulta
        int affectedRows = comando.executeUpdate();
        try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                setId(generatedKeys.getLong(1));
            } else  throw new SQLException("Creating user failed, no ID obtained.");
        }
        conexao.close();
    }

    private void salvarRequisicao(RespostaFornecedor requisicao) throws Exception {
        Connection conexao = Conexao.get();
        String sql = "INSERT INTO requisicoes (idConsulta, idFornecedor, custo, resposta) VALUES (?, ?, ?, ?)";
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setLong(1, getId());
        comando.setString(2, requisicao.getFornecedor().getId());
        comando.setBigDecimal(3, requisicao.getCustoDaRequisicao());
        comando.setString(4, requisicao.getRespostaPura());
        comando.executeUpdate();

        conexao.close();
    }

    public static List<Consulta> obterTodas() throws Exception {
        Connection conexao = Conexao.get();
        String sql = "SELECT * FROM consultas";
        PreparedStatement comando = conexao.prepareStatement(sql);
        ResultSet resultado = comando.executeQuery();
        List<Consulta> consultas = new ArrayList<>();
        while (resultado.next()) {
            Consulta consulta = new Consulta(resultado.getString("placa"));
            consulta.setId(resultado.getLong("id"));
            consulta.setDataEHora(resultado.getObject("dataEHora", LocalDateTime.class));
            consultas.add(consulta);
            String sqlRequisicoes = "SELECT * FROM requisicoes WHERE idConsulta = ?";
            PreparedStatement comandoRequisicoes = conexao.prepareStatement(sqlRequisicoes);
            comandoRequisicoes.setLong(1, consulta.getId());

            ResultSet resultadoRequisicoes = comandoRequisicoes.executeQuery();
            while (resultadoRequisicoes.next()) {
                String idFornecedor = resultadoRequisicoes.getString("idFornecedor");
                String resposta = resultadoRequisicoes.getString("resposta");
                BigDecimal custo = resultadoRequisicoes.getBigDecimal("custo");
                RespostaFornecedor respostaFornecedor = null;
                if(idFornecedor.equals("detran-sp")){
                    respostaFornecedor = new RespostaFornecedorDetran(consulta, resposta, custo);
                }else if(idFornecedor.equals("senatran")) {
                    respostaFornecedor = new RespostaFornecedorSenatran(consulta, resposta, custo);
                }
                consulta.requisicoes.add(respostaFornecedor);
            }


        }
        conexao.close();
        return consultas;
    }
}


