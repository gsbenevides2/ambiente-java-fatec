package dev.gsbenevides2.Conta;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GerenciadorDeContas {
    private static ArrayList<ContaCorrente> contas = new ArrayList<>();

    public static ContaCorrente abrirConta(String titular, String numero, ChavePix chavePix) {
        if(buscarConta(numero) != null) {
            throw new IllegalArgumentException("A conta com a numeração informada já está aberta.");
        }
        if(buscarConta(chavePix) != null) {
            throw new IllegalArgumentException("A conta com a chave Pix informada já está aberta.");
        }
        ContaCorrente contaAberta = new ContaCorrente(titular, numero, chavePix);
        contas.add(contaAberta);
        return contaAberta;
    }
    public static ContaCorrente abrirConta(String titular, String numero, BigDecimal saldoInicial, ChavePix chavePix) {
        ContaCorrente contaAberta = new ContaCorrente(titular, numero, saldoInicial, chavePix);
        contas.add(contaAberta);
        return contaAberta;
    }

    protected static ContaCorrente buscarConta(String numero) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    protected static ContaCorrente buscarConta(ChavePix chavePix) {
        for (ContaCorrente conta : contas) {
            if (conta.getChavePix().equals(chavePix)) {
                return conta;
            }
        }
        return null;
    }
}
