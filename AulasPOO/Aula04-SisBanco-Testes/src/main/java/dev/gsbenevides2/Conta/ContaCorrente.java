package dev.gsbenevides2.Conta;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class ContaCorrente {

    private String titular;
    private String numero;
    private BigDecimal saldo;
    private List<Transacao> transacoes = new ArrayList<>();
    private ChavePix chavePix;

    protected ContaCorrente(String titular, String numero){
        setTitular(titular);
        setNumero(numero);
        setSaldo(BigDecimal.ZERO);
    }

    protected ContaCorrente(String titular, String numero, BigDecimal saldoInicial) {
        this(titular,numero);
        setSaldo(saldoInicial);
    }
    protected ContaCorrente(String titular, String numero, ChavePix chavePix){
        this(titular,numero);
        setChavePix(chavePix);
    }
    protected ContaCorrente(String titular, String numero, BigDecimal saldoInicial, ChavePix chavePix) {
        this(titular, numero);
        setSaldo(saldoInicial);
        setChavePix(chavePix);
    }

    public String getNumero() {
        return numero;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    public ChavePix getChavePix() {
        return chavePix;
    }
    public String getTitular() {
        return titular;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }
    private void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    private void setChavePix(ChavePix chavePix) {
        this.chavePix = chavePix;
    }
    private void setTitular(String titular) {
        this.titular = titular;
    }

    private void debitar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor que será debitado deve ser maior que zero.");
        }
        if(getSaldo().compareTo(valor) < 0){
            throw new IllegalArgumentException("A conta possuí saldo insuficiente para essa operação.");
        }
        setSaldo(getSaldo().subtract(valor));
    }
    private void creditar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor que será creditado deve ser maior que zero.");
        }
        setSaldo(getSaldo().add(valor));
    }

    public void sacar(BigDecimal valor) {
        Transacao transacao = new Transacao(
                TipoOperacao.SAQUE,
                valor,
                saldo
        );
        debitar(valor);
        transacoes.add(transacao);
    }
    public void depositar(BigDecimal valor) {
        Transacao transacao = new Transacao(TipoOperacao.DEPOSITO, valor, saldo);
        creditar(valor);
        transacoes.add(transacao);
    }
    public void enviarTransferencia(String numeroDaContaDestino, BigDecimal valor) {
        ContaCorrente destino = GerenciadorDeContas.buscarConta(numeroDaContaDestino);
        if(destino == null){
            throw new IllegalArgumentException("A conta de destino não foi encontrada.");
        }
        Transacao transacao = new Transacao(
                TipoOperacao.TRANSFERENCIA_ENVIADA,
                valor,
                destino,
                saldo
        );
        debitar(valor);
        try {
            destino.receberTransferencia(this,valor);
            transacoes.add(transacao);
        } catch (IllegalArgumentException erro) {
            creditar(valor);
        }
    }
    private void receberTransferencia(ContaCorrente origem, BigDecimal valor){
        Transacao transacao = new Transacao(TipoOperacao.TRANSFERENCIA_RECEBIDA, valor, origem, saldo);
        this.creditar(valor);
        this.transacoes.add(transacao);
    }
    public void pagarBoleto(Boleto boleto){
        Transacao transacao = new Transacao(boleto, saldo);
        debitar(boleto.getValor());
        this.transacoes.add(transacao);
    }
    public void enviarPIX(ChavePix chaveDestino, BigDecimal valor) {
        ContaCorrente destino = GerenciadorDeContas.buscarConta(chaveDestino);
        if(destino == null){
            throw new IllegalArgumentException("A conta de destino não foi encontrada.");
        }
        Transacao transacao = new Transacao(
                TipoOperacao.PIX_ENVIADO,
                valor,
                getChavePix(),
                saldo
        );
        debitar(valor);
        try{
            destino.receberPIX(getChavePix(), valor);
            transacoes.add(transacao);
        }catch (Error err){
            creditar(valor);
            throw err;
        }
    }
    private void receberPIX(ChavePix chaveOrigem, BigDecimal valor){
        Transacao transacao = new Transacao(TipoOperacao.PIX_RECEBIDO, valor, chaveOrigem, saldo);
        this.creditar(valor);
        this.transacoes.add(transacao);
    }
}
