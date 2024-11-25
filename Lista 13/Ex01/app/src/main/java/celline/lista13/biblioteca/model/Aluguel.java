package celline.lista13.biblioteca.model;

import java.time.LocalDate;

public class Aluguel {

    private Aluno aluno;
    private Exemplar exemplar;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Aluguel(Aluno aluno, Exemplar exemplar, LocalDate dataRetirada, LocalDate dataDevolucao) {
        this.aluno = aluno;
        this.exemplar = exemplar;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }
    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Aluno = " + getAluno() + "\n" +
                "Exemplar = " + getExemplar() + "\n" +
                "Data da Retirada = " + getDataRetirada() + "\n" +
                "Data da Devolução = " + getDataDevolucao() + "\n";
    }
}
