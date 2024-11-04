package celline.lista08.cadastroatletas.controller;

import java.util.ArrayList;
import java.util.List;

import celline.lista08.cadastroatletas.model.Juvenil;

public class OperacaoJuvenil implements IOperacao<Juvenil> {

    private List<Juvenil> lista;

    public OperacaoJuvenil() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(Juvenil juvenil) {
        lista.add(juvenil);
    }

    @Override
    public List<Juvenil> listar() {
        return this.lista;
    }
}
