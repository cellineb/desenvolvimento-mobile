package celline.trabalhosemestral.agenda.persistence;

import java.sql.SQLException;

import celline.trabalhosemestral.agenda.model.Tarefas;

public interface ITarefasDao {
    public TarefasDao open() throws SQLException;
    public void close();
}
