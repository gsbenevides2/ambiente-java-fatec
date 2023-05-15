package dev.gsbenevides2.Conta;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public class Transacao {
    private LocalDateTime dataHora;
    private BigDecimal saldoAntes;
    private BigDecimal valor;
    private ContaCorrente outraContaEnvolvida;
    private ChavePix chavePixEnvolvida;
    private TipoOperacao tipoOperacao;
    private Boleto boletoEnvolvido;

    public Transacao(TipoOperacao tipoOperacao, BigDecimal valor, BigDecimal saldoAntes) {
        if(tipoOperacao == TipoOperacao.TRANSFERENCIA_ENVIADA || tipoOperacao == TipoOperacao.TRANSFERENCIA_RECEBIDA) {
            throw new IllegalArgumentException("Este construtor não recebe uma conta destino e, por isso, não pode ser usado para transferências. Use o outro construtor.");
        }
        if(tipoOperacao == TipoOperacao.BOLETO){
            throw new IllegalArgumentException("Este construtor não recebe um boleto e, por isso, não pode ser usado para boletos. Use o outro construtor.");
        }
        if(tipoOperacao == TipoOperacao.PIX_ENVIADO || tipoOperacao == TipoOperacao.PIX_RECEBIDO){
            throw new IllegalArgumentException("Este construtor não recebe uma chave pix e, por isso, não pode ser usado para PIX. Use o outro construtor.");
        }

        setDataHora(LocalDateTime.now());
        setTipoOperacao(tipoOperacao);
        setValor(valor);
        setSaldoAntes(saldoAntes);
    }
    public Transacao(TipoOperacao tipoOperacao, BigDecimal valor, ContaCorrente outraContaEnvolvida, BigDecimal saldoAntes) {
        if(tipoOperacao != TipoOperacao.TRANSFERENCIA_ENVIADA && tipoOperacao != TipoOperacao.TRANSFERENCIA_RECEBIDA) {
            throw new IllegalArgumentException("Este construtor recebe uma conta destino e, por isso, só pode ser usado para transferências. Use o outro construtor.");
        }
        setDataHora(LocalDateTime.now());
        setTipoOperacao(tipoOperacao);
        setValor(valor);
        setOutraContaEnvolvida(outraContaEnvolvida);
        setSaldoAntes(saldoAntes);
    }
    public Transacao(TipoOperacao tipoOperacao, BigDecimal valor, ChavePix chavePixEnvolvida, BigDecimal saldoAntes) {
        if(tipoOperacao != TipoOperacao.PIX_ENVIADO && tipoOperacao != TipoOperacao.PIX_RECEBIDO) {
            throw new IllegalArgumentException("Este construtor recebe uma chave pix e, por isso, só pode ser usado para PIX. Use o outro construtor.");
        }
        setDataHora(LocalDateTime.now());
        setTipoOperacao(tipoOperacao);
        setValor(valor);
        setChavePixEnvolvida(chavePixEnvolvida);
        setSaldoAntes(saldoAntes);
    }
    public Transacao(Boleto boleto, BigDecimal saldoAntes) {
        setDataHora(LocalDateTime.now());
        setTipoOperacao(TipoOperacao.BOLETO);
        setValor(boleto.getValor());
        setSaldoAntes(saldoAntes);
        setBoletoEnvolvido(boleto);

    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public ContaCorrente getOutraContaEnvolvida() {
        return outraContaEnvolvida;
    }
    public ChavePix getChavePixEnvolvida() {
        return chavePixEnvolvida;
    }
    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }
    public BigDecimal getSaldoAntes() {
        return saldoAntes;
    }
    public Boleto getBoletoEnvolvido() {
        return boletoEnvolvido;
    }



    private void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    private void setValor(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }
        this.valor = valor;
    }
    private void setOutraContaEnvolvida(ContaCorrente outraContaEnvolvida) {
        this.outraContaEnvolvida = outraContaEnvolvida;
    }
    private void setChavePixEnvolvida(ChavePix chavePixEnvolvida) {
        this.chavePixEnvolvida = chavePixEnvolvida;
    }
    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        if(tipoOperacao == null) {
            throw new IllegalArgumentException("O tipo de transação é obrigatório");
        }
        this.tipoOperacao = tipoOperacao;
    }
    private void setSaldoAntes(BigDecimal saldoAntes) {
        this.saldoAntes = saldoAntes;
    }
    private void setBoletoEnvolvido(Boleto boletoEnvolvido) {
        this.boletoEnvolvido = boletoEnvolvido;
    }
}
