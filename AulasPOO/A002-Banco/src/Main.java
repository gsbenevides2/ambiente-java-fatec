import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
       ContaBancaria contaDoAbreu = new ContaBancaria("220011");
       ContaBancaria contaDaMaria = new ContaBancaria("220012");
       System.out.println("Abertas contas bancárias para Abreu e Maria as duas começam com saldo zerado.");

       contaDoAbreu.depositar(100);
       System.out.println("Depósito de 100 reais realizado com sucesso na conta do Abreu!");

       try{
           contaDaMaria.sacar(new BigDecimal("12.0"));
           System.out.println("Que milagre! Maria conseguiu sacar 12 reais sem ter saldo para isso!");
       }catch (IllegalArgumentException ex){
           if(ex.getMessage().equals("Saldo insuficiente para a operação!")){
               System.out.println("Erro: Não foi possivel sacar 12 reais da conta da maria ela não possui saldo suficiente!");
           }
       }

       contaDoAbreu.transferirPara(contaDaMaria, 12);
       System.out.println("Transferido 12 reais de Abreu para Maria!");

       contaDaMaria.sacar(10);
       System.out.println("Maria sacou 10 reais!");

       System.out.println("Segue se o saldo da conta do Abreu:");
       System.out.println("Conta Número: " + contaDoAbreu.getNumero() + " Saldo: " + contaDoAbreu.getSaldo());
       System.out.println("Segue se o saldo da conta da Maria:");
       System.out.println("Conta Número: " + contaDaMaria.getNumero() + " Saldo: " + contaDaMaria.getSaldo());
    }
}