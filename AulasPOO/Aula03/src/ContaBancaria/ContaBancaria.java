package ContaBancaria;

import java.math.BigDecimal;
public class ContaBancaria {
    private BigDecimal saldo;
    private String numero;

    ContaBancaria(String numero) {
        this.setNumero(numero);
        this.setSaldo(BigDecimal.ZERO);
    }
    public void depositar(BigDecimal valor){
        this.creditar(valor);
    }
    public void depositar(int valor){
        this.depositar(BigDecimal.valueOf(valor));
    }
    public void sacar(BigDecimal valor){
        this.debitar(valor);
    }
    public void sacar(int valor){
        this.sacar(BigDecimal.valueOf(valor));
    }
    public void transferirPara(ContaBancaria conta, BigDecimal valor){
        if(conta.getNumero().equals(this.getNumero())) throw new IllegalArgumentException("A conta de origem não pode ser a mesma de destino!");
        this.debitar(valor);
        try {
            conta.creditar(valor);
        }catch (Error err){
            this.creditar(valor);
            throw err;
        }
    }
    public void transferirPara(ContaBancaria conta, int valor){
        this.transferirPara(conta, BigDecimal.valueOf(valor));
    }
    public BigDecimal getSaldo(){
        return this.saldo;
    }
    public String getNumero(){
        return this.numero;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }
    private void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }
    private void debitar(BigDecimal valor){
        int compareResult = valor.compareTo(BigDecimal.ZERO);
        if(compareResult <= 0) throw new IllegalArgumentException("O valor a debitar precisa ser maior que zero!");
        if(getSaldo().compareTo(valor) == -1) throw new IllegalArgumentException("Saldo insuficiente para a operação!");
        this.setSaldo(getSaldo().subtract(valor));
    }
    private void creditar(BigDecimal valor){
        int compareResult = valor.compareTo(BigDecimal.ZERO);
        if(compareResult <= 0) throw new IllegalArgumentException("O valor a creditar precisa ser maior que zero!");
        this.setSaldo(getSaldo().add(valor));
    }
}
