package dev.gsbenevides2.Conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {
    private String codigoDeBarras;
    private BigDecimal valor;
    private LocalDate dataDeVencimento;

    public Boleto(String codigoDeBarras, BigDecimal valor, LocalDate dataDeVencimento) {
        this.setCodigoDeBarras(codigoDeBarras);
        this.setValor(valor);
        this.setDataDeVencimento(dataDeVencimento);
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    private void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    private void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    private void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}
