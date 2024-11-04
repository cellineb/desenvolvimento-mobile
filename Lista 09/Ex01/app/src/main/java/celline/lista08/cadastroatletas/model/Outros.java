package celline.lista08.cadastroatletas.model;

public class Outros extends Atleta{

    private String academia;
    private int record;

    public Outros() {
        this.academia = academia;
    }

    public String getAcademia() {
        return academia;
    }
    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getRecord() {
        return record;
    }
    public void setRecord(int record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Outros{" +
                "academia='" + academia + '\'' +
                ", record=" + record +
                '}';
    }
}
