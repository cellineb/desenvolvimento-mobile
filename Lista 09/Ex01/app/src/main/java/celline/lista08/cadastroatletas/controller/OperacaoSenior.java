package celline.lista08.cadastroatletas.controller;

import java.util.ArrayList;
import java.util.List;

import celline.lista08.cadastroatletas.model.Senior;

/*
*@author: Celline
*/
public class OperacaoSenior implements IOperacao<Senior>{

    private List<Senior> lista;

    public OperacaoSenior() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(Senior senior) {
        lista.add(senior);
    }

    @Override
    public List<Senior> listar() {
        return this.lista;
    }
}
