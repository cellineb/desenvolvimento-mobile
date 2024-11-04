package celline.lista08.cadastroatletas.model;

public class Senior extends Atleta{

    private boolean problemasCard;

    public Senior() {
        this.problemasCard = problemasCard;
    }

    public boolean isProblemasCard() {
        return problemasCard;
    }
    public void setProblemasCard(boolean problemasCard) {
        this.problemasCard = problemasCard;
    }

    @Override
    public String toString() {
        return "Senior{" +
                "problemasCard=" + problemasCard +
                "nome='" + getNome() + '\'' +
                ", data='" + getData() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                '}';
    }
}
