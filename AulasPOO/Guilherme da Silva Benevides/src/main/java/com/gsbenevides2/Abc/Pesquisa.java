package com.gsbenevides2.Abc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pesquisa {
    private Interessado interessado;
    private List<Residencial> residenciaisEncontrados = new ArrayList<>();
    private LocalDate dataDaPesquisa;
    private Integer precoMinimo;
    private Integer precoMaximo;
    private String cidade;
    private String estado;
    private Regiao regiao;


    private Integer qtdDeTentativas = 0;

    protected Pesquisa(Interessado interessado,
                       Integer precoMinimo,
                       Integer precoMaximo,
                       String cidade,
                       String estado,
                       Regiao regiao
    ) {
        this.interessado = interessado;
        this.dataDaPesquisa = LocalDate.now();
        this.precoMinimo = precoMinimo;
        this.precoMaximo = precoMaximo;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
    }

    protected void addResidenciais(Collection<Residencial> residencials) {
        this.getResidenciaisEncontrados().addAll(residencials);
        this.qtdDeTentativas++;
    }

    public Interessado getInteressado() {
        return interessado;
    }

    public List<Residencial> getResidenciaisEncontrados() {
        return residenciaisEncontrados;
    }

    public LocalDate getDataDaPesquisa() {
        return dataDaPesquisa;
    }

    public Integer getQtdDeTentativas() {
        return qtdDeTentativas;
    }

    public Integer getPrecoMinimo() {
        return precoMinimo;
    }

    public Integer getPrecoMaximo() {
        return precoMaximo;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Pesquisa pesquisa)) return false;
        if(!(pesquisa.estado.equals(this.estado))) return false;
        if(!(pesquisa.cidade.equals(this.cidade))) return false;
        if(!(pesquisa.precoMaximo.equals(this.precoMaximo))) return false;
        if(!pesquisa.precoMinimo.equals(this.precoMinimo)) return false;
        return pesquisa.interessado.equals(this.interessado);
    }

    public Boolean residencialMatch(Residencial residencial){
        Endereco endereco = residencial.getEndereco();
        Boolean localidadeOK = endereco.getRegiao().equals(regiao) && endereco.getEstado().equals(estado) && endereco.getCidade().equals(cidade);
        Integer preco = residencial.getPreco();
        Boolean precoOK = preco >= precoMinimo && preco <= precoMaximo;
        Boolean naoIncluido = !this.residenciaisEncontrados.contains(residencial);
        return localidadeOK && precoOK && naoIncluido;
    }
}
