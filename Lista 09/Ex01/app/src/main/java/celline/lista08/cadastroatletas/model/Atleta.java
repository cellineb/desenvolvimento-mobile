package celline.lista08.cadastroatletas.model;

/*
*@author: Celline
*/
public class Atleta {

    private String nome;
    private String data;
    private String bairro;

    public Atleta() {
        this.nome = nome;
        this.data = data;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
