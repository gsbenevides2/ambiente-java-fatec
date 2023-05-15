import java.math.BigDecimal;
public class ContaBancaria {
    private BigDecimal saldo;
    private String numero;
    ContaBancaria(String numero){
        this.numero = numero;
        saldo = new BigDecimal("0.0");
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
        if(conta.numero.equals(this.numero)) throw new IllegalArgumentException("A conta de origem não pode ser a mesma de destino!");
        this.debitar(valor);
        conta.creditar(valor);
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

    private void debitar(BigDecimal valor){
        int compareResult = valor.compareTo(new BigDecimal("0"));
        if(compareResult <= 0) throw new IllegalArgumentException("O valor a debitar precisa ser maior que zero!");
        if(this.saldo.compareTo(valor) == -1) throw new IllegalArgumentException("Saldo insuficiente para a operação!");
        this.saldo = this.saldo.subtract(valor);
    }
    private void creditar(BigDecimal valor){
        int compareResult = valor.compareTo(new BigDecimal("0"));
        if(compareResult <= 0) throw new IllegalArgumentException("O valor a creditar precisa ser maior que zero!");
        this.saldo = this.saldo.add(valor);
    }
}
