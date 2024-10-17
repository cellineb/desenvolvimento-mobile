package celline.lista05.salarioprofessores.model;

public class Horista extends Professor{

    private int horasAula;
    private double valorHoraAula;
    private double salario;

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /*
     *@author: Celline
     */
    @Override
    public double calcSalario() {
        salario = horasAula * valorHoraAula;
        return salario;
    }
}
