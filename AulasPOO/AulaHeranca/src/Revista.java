public class Revista  extends PublicacaoImpressa{
    private String issn;
    private int mesPublicacao;
    private int numero;
    public String getIssn() {
        return issn;
    }
    public void setIssn(String issn) {
        this.issn = issn;
    }
    public int getMesPublicacao() {
        return mesPublicacao;
    }
    public void setMesPublicacao(int mesPublicacao) {
        this.mesPublicacao = mesPublicacao;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
