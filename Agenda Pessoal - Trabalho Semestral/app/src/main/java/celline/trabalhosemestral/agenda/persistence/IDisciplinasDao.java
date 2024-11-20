package celline.trabalhosemestral.agenda.persistence;

import java.sql.SQLException;

import celline.trabalhosemestral.agenda.model.Disciplina;

public interface IDisciplinasDao {
    public DisciplinasDao open() throws SQLException;
    public void close();
}
