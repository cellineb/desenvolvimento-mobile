package celline.lista13.biblioteca.model;

public class Aluno {

    private int RA;
    private String nome;
    private String email;

    public Aluno(int RA, String nome, String email) {
        this.RA = RA;
        this.nome = nome;
        this.email = email;
    }

    public int getRA() {
        return RA;
    }
    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RA = " + getRA() + "\n" +
                "Nome = " + getNome() + "\n" +
                "Email = " + getEmail() + "\n";
    }
}
