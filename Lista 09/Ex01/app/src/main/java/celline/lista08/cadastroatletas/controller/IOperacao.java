package celline.lista08.cadastroatletas.controller;

import java.util.List;

public interface IOperacao<T>{

    public void cadastrar(T t);
    public List<T> listar();

}
