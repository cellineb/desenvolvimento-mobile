package celline.lista13.biblioteca.model;

public class Livro extends Exemplar{

    private String ISBN;
    private int edicao;

    public Livro(int codigo, String nome, int qtdPaginas, String ISBN, int edicao) {
        super(codigo, nome, qtdPaginas);
        this.ISBN = ISBN;
        this.edicao = edicao;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return "Nome = " + getNome() + "\n" +
                "Código = " + getCodigo() + "\n" +
                "Páginas = " + getQtdPaginas() + "\n" +
                "ISBN = " + getISBN() + "\n" +
                "Edição = " + getEdicao() + "\n";
    }
}
