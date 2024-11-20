package celline.trabalhosemestral.agenda.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Disciplina;
import celline.trabalhosemestral.agenda.persistence.DisciplinasDao;

public class DisciplinaController implements IController<Disciplina> {

    private final DisciplinasDao dDao;

    public DisciplinaController(DisciplinasDao dDao) {
        this.dDao = dDao;
    }

    @Override
    public void inserir(Disciplina disciplina) throws SQLException {
        if (dDao ==  null){
            dDao.open();
        }
        dDao.insert(disciplina);
        dDao.close();
    }

    @Override
    public void editar(Disciplina disciplina) throws SQLException {
        if (dDao ==  null){
            dDao.open();
        }
        dDao.update(disciplina);
        dDao.close();
    }

    @Override
    public void excluir(Disciplina disciplina) throws SQLException {
        if (dDao ==  null){
            dDao.open();
        }
        dDao.delete(disciplina);
        dDao.close();
    }

    @Override
    public Disciplina buscar(Disciplina disciplina) throws SQLException {
        if (dDao ==  null){
            dDao.open();
        }
        return dDao.findOne(disciplina);
    }

    @Override
    public List<Disciplina> listar() throws SQLException {
        if (dDao ==  null){
            dDao.open();
        }
        return dDao.findAll();
    }
}
