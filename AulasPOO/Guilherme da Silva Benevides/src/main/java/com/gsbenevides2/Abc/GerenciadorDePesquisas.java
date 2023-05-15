package com.gsbenevides2.Abc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorDePesquisas {

    private List<Interessado> interessadosCadastrados = new ArrayList<>();
    private List<Residencial> residenciaisCadastrados = new ArrayList<>();

    private List<Pesquisa> pesquisasRealizadas = new ArrayList<>();

    static GerenciadorDePesquisas instance;

    private GerenciadorDePesquisas() {
    }

    public static GerenciadorDePesquisas getInstance() {
        if (instance != null) return instance;
        else {
            instance = new GerenciadorDePesquisas();
            return instance;
        }
    }

    public Pesquisa fazerPesquisa(
            Integer precoMinimo,
            Integer precoMaximo,
            String estado,
            String cidade,
            Regiao regiao,
            String nome,
            String telefone,
            String primeiroNomeDoIdoso,
            String email
    ) throws Exception {
        Interessado interessado = interessadosCadastrados
                .stream()
                .filter(interessado1 -> interessado1.equals(new Interessado(nome, telefone, primeiroNomeDoIdoso, email)))
                .findFirst()
                .orElseGet(()-> {
                    Interessado inte = new Interessado(nome, telefone, primeiroNomeDoIdoso, email);
                    interessadosCadastrados.add(inte);
                    return inte;
                });

        Pesquisa pesquisa = pesquisasRealizadas
                .stream()
                .filter(pesquisa1 -> pesquisa1.equals(new Pesquisa(interessado, precoMinimo, precoMaximo, cidade, estado, regiao)))
                .findFirst()
                .orElseGet(()-> {
                    Pesquisa pes =  new Pesquisa(interessado, precoMinimo, precoMaximo, cidade, estado, regiao);
                    pesquisasRealizadas.add(pes);
                    return pes;
                });

        if (pesquisa.getQtdDeTentativas() == 3)
            throw new Exception("Você ultrapassou o limite diário de pesquisas volte amanhã!");

        List<Residencial> residenciaisEncontrados = new ArrayList<>(residenciaisCadastrados
                .stream()
                .filter(pesquisa::residencialMatch)
                .toList());

        Collections.shuffle(residenciaisEncontrados);
        if(residenciaisEncontrados.size() == 0) throw new Exception("Não foram encontrados residenciais para sua pesquisa tente novamente");
        pesquisa.addResidenciais(residenciaisEncontrados.subList(0,3));

        return pesquisa;
    }

    public void cadastrarResidencial(
            String nome,
            Endereco endereco,
            Integer avaliacao,
            String telefone,
            Integer preco
    ) throws Exception {
        Residencial residencial =  new Residencial(
                nome,
                endereco,
                avaliacao,
                telefone,
                preco
        );
        if(this.residenciaisCadastrados.contains(residencial)) throw new IllegalArgumentException("Residencial com mesmo telfone cadastrado");

        this.residenciaisCadastrados.add(residencial);
    }

    public List<Pesquisa> obterPesquisarRealizadas(){
        return this.pesquisasRealizadas;
    }
}
