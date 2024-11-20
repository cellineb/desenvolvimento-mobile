package celline.trabalhosemestral.agenda.persistence;

import java.sql.SQLException;

public interface ICompromissosDao {
    public CompromissosDao open() throws SQLException;
    public void close();
}
