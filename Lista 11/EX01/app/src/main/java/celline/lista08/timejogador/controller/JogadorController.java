package celline.lista08.timejogador.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import celline.lista08.timejogador.model.Jogador;
import celline.lista08.timejogador.persistence.JogadorDao;

/*
 *@author: Celline
 */
public class JogadorController implements IController<Jogador>{

    private final JogadorDao jDao;

    public JogadorController(JogadorDao jDao) {
        this.jDao = jDao;
    }

    @Override
    public void inserir(Jogador jogador) throws SQLException {
        if (jDao ==  null){
            jDao.open();
        }
        jDao.insert(jogador);
        jDao.close();
    }

    @Override
    public void editar(Jogador jogador) throws SQLException {
        if (jDao ==  null){
            jDao.open();
        }
        jDao.update(jogador);
        jDao.close();
    }

    @Override
    public void excluir(Jogador jogador) throws SQLException {
        if (jDao ==  null){
            jDao.open();
        }
        jDao.delete(jogador);
        jDao.close();
    }

    @Override
    public Jogador buscar(Jogador jogador) throws SQLException {
        if (jDao ==  null){
            jDao.open();
        }
        return jDao.findOne(jogador);
    }

    @Override
    public List<Jogador> listar() throws SQLException {
        if (jDao ==  null){
            jDao.open();
        }
        return jDao.findAll();
    }


}
