package dev.gsbenevides2;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_FixedWidth;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import dev.gsbenevides2.Conta.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrincipalConta {
    public static void main(String[] args) {
        ContaCorrente contaDoAbreu = GerenciadorDeContas.abrirConta("Abreu da Silva","1234-5", new BigDecimal("5000"), new ChavePix("123456789", TipoChavePix.CPF));
        ContaCorrente contaDaMaria = GerenciadorDeContas.abrirConta("Maria da Costa","1234-6", new ChavePix("987654321", TipoChavePix.CPF));

        contaDoAbreu.sacar(new BigDecimal("100"));
        contaDoAbreu.sacar(new BigDecimal("50"));
        contaDoAbreu.sacar(new BigDecimal("200"));
        contaDoAbreu.depositar(new BigDecimal("25"));
        contaDoAbreu.depositar(new BigDecimal("10"));

        contaDoAbreu.enviarTransferencia(contaDaMaria.getNumero(), new BigDecimal("200"));
        contaDaMaria.enviarPIX(contaDoAbreu.getChavePix(), new BigDecimal("100"));

        Boleto boleto = new Boleto("123456789", new BigDecimal("100"), LocalDateTime.now().plusDays(5).toLocalDate());
        contaDoAbreu.pagarBoleto(boleto);

        exibirExtrato(contaDoAbreu);
        exibirExtrato(contaDaMaria);
    }
    private static void exibirExtrato(ContaCorrente conta){
        AsciiTable at = new AsciiTable();

        at.addRule();
        AT_Row titleRow = at.addRow(null,null,null,"SISBP - Sistema de Informações do Banco dos Programadores");
        titleRow.getCells().get(3).getContext().setTextAlignment(TextAlignment.CENTER);

        at.addRule();
        at.addRow(null,"Titular: " + conta.getTitular(),null, "Extrato da conta Nº" + conta.getNumero() );
        at.addRule();
        String formatedSaldo = String.format("R$ %.2f", conta.getSaldo());
        at.addRow(null, null, null,"Saldo Atual: " + formatedSaldo);
        at.addRule();
        AT_Row headerRow = at.addRow("Data/Hora", "Operação", "Saldo Anterior", "Valor");
        headerRow.getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
        headerRow.getCells().get(1).getContext().setTextAlignment(TextAlignment.CENTER);
        headerRow.getCells().get(2).getContext().setTextAlignment(TextAlignment.CENTER);
        headerRow.getCells().get(3).getContext().setTextAlignment(TextAlignment.CENTER);
        for(Transacao transacao: conta.getTransacoes()) {
            at.addRule();
            String formatedValor = String.format("R$ %.2f", transacao.getValor());
            String formatedSaldoAnterior = String.format("R$ %.2f", transacao.getSaldoAntes());
            AT_Row row = at.addRow(
                    transacao.getDataHora().format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                    ),
                    transacao.getTipoOperacao().name(),
                    formatedSaldoAnterior,
                    formatedValor

            );
            row.getCells().get(2).getContext().setTextAlignment(TextAlignment.CENTER);
            row.getCells().get(3).getContext().setTextAlignment(TextAlignment.CENTER);
        }
        at.addRule();
        at.addRow(null,null,null,"O Banco dos Programadores tem uma oportunidade de emprestimo para você! Vá até uma agência mais próxima e peça um emprestimo pessoal.");
        at.addRule();
        at.addRow(null, null, null, "Documento gerado em: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        at.addRow(null,null,null,"Obrigado por utilizar o SISBP!");
        at.addRule();
        at.getRenderer().setCWC(new CWC_FixedWidth().add(20).add(40).add(20).add(10));
        System.out.println(at.render());
    }
}
