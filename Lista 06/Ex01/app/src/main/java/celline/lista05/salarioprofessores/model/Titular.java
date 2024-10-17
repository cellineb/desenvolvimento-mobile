package celline.lista05.salarioprofessores.model;

public class Titular extends Professor {

    private int anosInstituicao;
    private double salario;

    public Titular(){
        super();
    }

    public double getSalario() {
        return calcSalario();
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    /*
     *@author: Celline
     */
    @Override
    public double calcSalario() {

        int bonus = getAnosInstituicao()/5;
        salario = 2000;
        for (int i = 0; i < bonus; i++){
            salario = salario + (salario * 0.05);
        }
        return salario;
    }

}
