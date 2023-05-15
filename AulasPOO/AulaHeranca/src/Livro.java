import java.util.List;

public class Livro extends PublicacaoImpressa {
    private String isbn;
    private String tituloOriginal;
    private List<Autor> autores;
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTituloOriginal() {
        return tituloOriginal;
    }
    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
