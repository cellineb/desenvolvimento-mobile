package celline.lista08.timejogador.model;

import java.time.LocalDate;

/*
 *@author: Celline
 */
public class Jogador {

    private int id;
    private String nome;
    private LocalDate dataNasc;
    private float altura;
    private float peso;
    private Time codTime;

    public Jogador() {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.altura = altura;
        this.peso = peso;
        this.codTime = codTime;
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

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Time getCodTime() {
        return codTime;
    }
    public void setCodTime(Time time) {
        this.codTime = codTime;
    }

    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", altura=" + altura +
                ", peso=" + peso +
                ", time=" + codTime +
                '}';
    }
}
