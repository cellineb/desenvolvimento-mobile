package celline.lista08.cadastroatletas.controller;

import java.util.ArrayList;
import java.util.List;

import celline.lista08.cadastroatletas.model.Outros;

public class OperacaoOutros implements IOperacao<Outros>{

    private List<Outros> lista;

    public OperacaoOutros() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(Outros outros) {
        lista.add(outros);
    }

    @Override
    public List<Outros> listar() {
        return this.lista;
    }
}
