package celline.trabalhosemestral.agenda.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Tarefas;
import celline.trabalhosemestral.agenda.persistence.TarefasDao;

public class TarefasController implements IController<Tarefas> {

    private final TarefasDao tDao;

    public TarefasController(TarefasDao tDao) {
        this.tDao = tDao;
    }

    @Override
    public void inserir(Tarefas tarefas) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.insert(tarefas);
        tDao.close();
    }

    @Override
    public void editar(Tarefas tarefas) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.update(tarefas);
        tDao.close();
    }

    @Override
    public void excluir(Tarefas tarefas) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.delete(tarefas);
        tDao.close();
    }

    @Override
    public Tarefas buscar(Tarefas tarefas) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        return  tDao.findOne(tarefas);
    }

    @Override
    public List<Tarefas> listar() throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        return tDao.findAll();
    }
}
