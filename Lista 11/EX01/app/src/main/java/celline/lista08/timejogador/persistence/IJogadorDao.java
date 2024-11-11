package celline.lista08.timejogador.persistence;

import java.sql.SQLException;

/*
 *@author: Celline
 */
public interface IJogadorDao {

    public JogadorDao open() throws SQLException;
    public void close();
}
