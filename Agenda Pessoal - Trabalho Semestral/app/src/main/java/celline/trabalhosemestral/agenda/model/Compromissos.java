package celline.trabalhosemestral.agenda.model;

public class Compromissos {

    private int id;
    private String nome;
    private float data;
    private String hora;
    private String obs;

    public Compromissos() {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getData() {
        return data;
    }
    public void setData(float data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Compromissos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", obs='" + obs + '\'' +
                '}';
    }
}
