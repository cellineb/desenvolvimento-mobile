package celline.trabalhosemestral.agenda.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Compromissos;
import celline.trabalhosemestral.agenda.persistence.CompromissosDao;

public class CompromissosController implements IController<Compromissos>{

    private final CompromissosDao cDao;

    public CompromissosController(CompromissosDao cDao) {
        this.cDao = cDao;
    }

    @Override
    public void inserir(Compromissos compromissos) throws SQLException {
        if (cDao ==  null){
            cDao.open();
        }
        cDao.insert(compromissos);
        cDao.close();
    }

    @Override
    public void editar(Compromissos compromissos) throws SQLException {
        if (cDao ==  null){
            cDao.open();
        }
        cDao.update(compromissos);
        cDao.close();
    }

    @Override
    public void excluir(Compromissos compromissos) throws SQLException {
        if (cDao ==  null){
            cDao.open();
        }
        cDao.delete(compromissos);
        cDao.close();
    }

    @Override
    public Compromissos buscar(Compromissos compromissos) throws SQLException {
        if (cDao ==  null){
            cDao.open();
        }
        return cDao.findOne(compromissos);
    }

    @Override
    public List<Compromissos> listar() throws SQLException {
        if (cDao ==  null){
            cDao.open();
        }
        return cDao.findAll();
    }
}
