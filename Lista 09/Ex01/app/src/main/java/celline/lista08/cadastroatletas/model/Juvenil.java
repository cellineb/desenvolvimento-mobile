package celline.lista08.cadastroatletas.model;

/*
*@author: Celline
*/
public class Juvenil extends Atleta {

    private int anosPraticando;

    public Juvenil() {
        this.anosPraticando = anosPraticando;
    }

    public int getAnosPraticando() {
        return anosPraticando;
    }
    public void setAnosPraticando(int anosPraticando) {
        this.anosPraticando = anosPraticando;
    }

    @Override
    public String toString() {
        return "Juvenil{" +
                "anosPraticando=" + anosPraticando +
                "nome='" + getNome() + '\'' +
                ", data='" + getData() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                '}';
    }
}
