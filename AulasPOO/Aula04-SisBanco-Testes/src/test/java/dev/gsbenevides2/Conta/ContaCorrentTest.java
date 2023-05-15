package dev.gsbenevides2.Conta;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Teste para a Conta Corrente
 */
public class ContaCorrentTest {
    /**
     * Testa a criação da conta, sem saldo inicial e sem nenhuma chave pix.
     */
    @Test
    public void testeDeCriaçãoDaConta(){
        String titular = "Abreu da Silva";
        String numeroDaConta = "123-4";
        ContaCorrente contaCorrente = new ContaCorrente(titular, numeroDaConta);
        Assert.assertEquals(titular,contaCorrente.getTitular());
        Assert.assertEquals(numeroDaConta, contaCorrente.getNumero());
        Assert.assertEquals(BigDecimal.ZERO, contaCorrente.getSaldo());
        Assert.assertNull(contaCorrente.getChavePix());
    }

    /**
     * Testa a criação de uma conta com saldo inicial
     */
    @Test
    public void testeDeCriaçãoConta2(){
        String titular = "Abreu da Silva";
        String numeroDaConta = "123-4";
        BigDecimal saldoInicial = new BigDecimal("1222");
        ContaCorrente contaCorrente = new ContaCorrente(titular, numeroDaConta, saldoInicial);
        Assert.assertEquals(titular,contaCorrente.getTitular());
        Assert.assertEquals(numeroDaConta, contaCorrente.getNumero());
        Assert.assertEquals(saldoInicial, contaCorrente.getSaldo());
        Assert.assertNull(contaCorrente.getChavePix());
    }

    /**
     * Testa a criação de uma conta com uma chave PIX
     */
    @Test
    public void testeDeCriaçãoConta3(){
        String titular = "Abreu da Silva";
        String numeroDaConta = "123-4";
        ChavePix chavePix = new ChavePix("123", TipoChavePix.CPF);
        ContaCorrente contaCorrente = new ContaCorrente(titular, numeroDaConta, chavePix);
        Assert.assertEquals(titular,contaCorrente.getTitular());
        Assert.assertEquals(numeroDaConta, contaCorrente.getNumero());
        Assert.assertEquals(BigDecimal.ZERO, contaCorrente.getSaldo());
        Assert.assertEquals(chavePix, contaCorrente.getChavePix());
    }

    /**
    * Testa a criação de uma conta com uma chave PIX e saldo Inicial
    */
    @Test
    public void testeDeCriaçãoConta4(){
        String titular = "Abreu da Silva";
        String numeroDaConta = "123-4";
        ChavePix chavePix = new ChavePix("123", TipoChavePix.CPF);
        BigDecimal saldoInicial = new BigDecimal("1222");
        ContaCorrente contaCorrente = new ContaCorrente(titular, numeroDaConta, saldoInicial, chavePix);
        Assert.assertEquals(titular,contaCorrente.getTitular());
        Assert.assertEquals(numeroDaConta, contaCorrente.getNumero());
        Assert.assertEquals(saldoInicial, contaCorrente.getSaldo());
        Assert.assertEquals(chavePix, contaCorrente.getChavePix());
    }

    /**
     * Teste de Depósito em Conta Sem Saldo
     */
    @Test
    public void testeDeDeposito(){
        ContaCorrente contaCorrente = new ContaCorrente("Abreu da Silva", "123-4");
        BigDecimal valorADepositar = new BigDecimal("200");
        contaCorrente.depositar(valorADepositar);
        Assert.assertEquals(valorADepositar, contaCorrente.getSaldo());
        List<Transacao> transacoes = contaCorrente.getTransacoes();

        Assert.assertFalse(transacoes.isEmpty());
        Assert.assertEquals(1, transacoes.size());

        Transacao primeiraTransacao = transacoes.get(0);
        Assert.assertNotNull(primeiraTransacao);

        Assert.assertEquals(TipoOperacao.DEPOSITO,primeiraTransacao.getTipoOperacao());
        Assert.assertEquals(BigDecimal.ZERO, primeiraTransacao.getSaldoAntes());
        Assert.assertEquals(valorADepositar,primeiraTransacao.getValor());
        Assert.assertNull(primeiraTransacao.getBoletoEnvolvido());
        Assert.assertNull(primeiraTransacao.getChavePixEnvolvida());
        Assert.assertNull(primeiraTransacao.getOutraContaEnvolvida());
        Assert.assertNotNull(primeiraTransacao.getDataHora());
    }

    /**
     * Teste de Depósito em Conta Com Saldo
     */
    @Test
    public void testeDeDeposito2(){
        BigDecimal saldoAnterior = new BigDecimal("300");
        BigDecimal valorADepositar = new BigDecimal("200");
        BigDecimal saldoAposAOperacao = saldoAnterior.add(valorADepositar);

        ContaCorrente contaCorrente = new ContaCorrente("Abreu da Silva", "123-4", saldoAnterior);
        contaCorrente.depositar(valorADepositar);
        Assert.assertEquals(saldoAposAOperacao, contaCorrente.getSaldo());
        List<Transacao> transacoes = contaCorrente.getTransacoes();

        Assert.assertFalse(transacoes.isEmpty());
        Assert.assertEquals(1, transacoes.size());

        Transacao primeiraTransacao = transacoes.get(0);
        Assert.assertNotNull(primeiraTransacao);

        Assert.assertEquals(TipoOperacao.DEPOSITO,primeiraTransacao.getTipoOperacao());
        Assert.assertEquals(saldoAnterior, primeiraTransacao.getSaldoAntes());
        Assert.assertEquals(valorADepositar,primeiraTransacao.getValor());
        Assert.assertNull(primeiraTransacao.getBoletoEnvolvido());
        Assert.assertNull(primeiraTransacao.getChavePixEnvolvida());
        Assert.assertNull(primeiraTransacao.getOutraContaEnvolvida());
        Assert.assertNotNull(primeiraTransacao.getDataHora());

    }

    /**
     * Teste de Deposito com valor Zero
     */
    @Test
    public void testeDeDeposito3(){
        ContaCorrente contaCorrente = new ContaCorrente("Abreu da Silva", "123-4");

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->contaCorrente.depositar(BigDecimal.ZERO)
        );

        Assert.assertEquals(
                "O valor da transação deve ser maior que zero.",
                thrown.getMessage()
        );
    }

    /**
     * Teste de Saque em Conta Sem Saldo
     */
    @Test
    public void testeDeSaque(){
        ContaCorrente contaCorrente = new ContaCorrente("Abreu da Silva", "123-3");
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> contaCorrente.sacar(new BigDecimal("23"))
        );
        Assert.assertEquals(
                "A conta possuí saldo insuficiente para essa operação.",
                thrown.getMessage()
        );
    }

    /**
     * Teste de Saque usando valor Zero
     */
    @Test
    public void testeDeSaque2(){
        ContaCorrente contaCorrente = new ContaCorrente("Abreu da Silva", "123-3");
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> contaCorrente.sacar(BigDecimal.ZERO)
        );
        Assert.assertEquals(
                "O valor da transação deve ser maior que zero.",
                thrown.getMessage()
        );
    }

    /**
     * Teste de Saque em Conta Com Saldo Insuficiente
     */
    @Test
    public void testeDeSaque3(){
        ContaCorrente conta = new ContaCorrente("Abreu da Silva", "123-3", new BigDecimal("100"));
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(new BigDecimal("200"))
        );
        Assert.assertEquals(
                "A conta possuí saldo insuficiente para essa operação.",
                thrown.getMessage()
        );
    }

    /**
     * Teste de Saque em Conta Com Saldo Suficiente
     */
    @Test
    public void testeDeSaque4(){
        BigDecimal saldoAntesDaOperacao = new BigDecimal("100");
        ContaCorrente conta = new ContaCorrente("Abreu da Silva", "123-3", saldoAntesDaOperacao);
        BigDecimal valorASacar = new BigDecimal("50");
        BigDecimal saldoAposOperacao = saldoAntesDaOperacao.subtract(valorASacar);
        conta.sacar(valorASacar);

        Assert.assertEquals(saldoAposOperacao, conta.getSaldo());

        List<Transacao> transacoes = conta.getTransacoes();
        Assert.assertFalse(transacoes.isEmpty());
        Assert.assertEquals(1, transacoes.size());

        Transacao primeiraTransacao = transacoes.get(0);

        Assert.assertEquals(TipoOperacao.SAQUE, primeiraTransacao.getTipoOperacao());
        Assert.assertEquals(saldoAntesDaOperacao, primeiraTransacao.getSaldoAntes());
        Assert.assertEquals(valorASacar, primeiraTransacao.getValor());
        Assert.assertNull(primeiraTransacao.getBoletoEnvolvido());
        Assert.assertNull(primeiraTransacao.getChavePixEnvolvida());
        Assert.assertNull(primeiraTransacao.getOutraContaEnvolvida());
        Assert.assertNotNull(primeiraTransacao.getDataHora());
    }
}
