package celline.trabalhosemestral.agenda.model;

public class Tarefas {

    private int id;
    private String nome;
    private float data;
    private String hora;
    private String tipoTarefa;
    private Disciplina disciplina;

    public Tarefas() {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.tipoTarefa = tipoTarefa;
        this.disciplina = disciplina;
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

    public String getTipoTarefa() {
        return tipoTarefa;
    }
    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", tipoTarefa='" + tipoTarefa + '\'' +
                ", disciplina= '" + disciplina + '\'' +
                '}';
    }
}
