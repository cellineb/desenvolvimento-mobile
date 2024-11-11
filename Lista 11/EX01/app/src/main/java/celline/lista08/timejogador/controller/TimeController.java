package celline.lista08.timejogador.controller;

import java.sql.SQLException;
import java.util.List;

import celline.lista08.timejogador.model.Time;
import celline.lista08.timejogador.persistence.TimeDao;

/*
 *@author: Celline
 */
public class TimeController implements IController<Time>{

    private final TimeDao tDao;

    public TimeController(TimeDao tDao) {
        this.tDao = tDao;
    }

    @Override
    public void inserir(Time time) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.insert(time);
        tDao.close();
    }

    @Override
    public void editar(Time time) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.update(time);
        tDao.close();
    }

    @Override
    public void excluir(Time time) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        tDao.delete(time);
        tDao.close();
    }

    @Override
    public Time buscar(Time time) throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        return tDao.findOne(time);
    }

    @Override
    public List<Time> listar() throws SQLException {
        if (tDao ==  null){
            tDao.open();
        }
        return tDao.findAll();
    }
}
