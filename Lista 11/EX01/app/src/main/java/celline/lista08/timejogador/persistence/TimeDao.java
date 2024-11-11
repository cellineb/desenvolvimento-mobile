package celline.lista08.timejogador.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import celline.lista08.timejogador.model.Time;

public class TimeDao implements ITimeDao, ICRUDDao<Time> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public TimeDao (Context context){
        this.context = context;
    }

    @Override
    public TimeDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }
    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Time time) throws SQLException {
        ContentValues contentValues = getContentValues(time);
        database.insert("time", null, contentValues);
    }

    @Override
    public int update(Time time) throws SQLException {
        ContentValues contentValues = getContentValues(time);
        database.update("time", contentValues, "codigo =" + time.getCodigo(), null);
        return 0;
    }

    @Override
    public void delete(Time time) throws SQLException {
        database.delete("time", "codigo =" + time.getCodigo(), null);
    }

    @Override
    public Time findOne(Time time) throws SQLException {
        return null;
    }

    @Override
    public List<Time> findAll(Time time) throws SQLException {
        return Collections.emptyList();
    }

    public static ContentValues getContentValues(Time time){
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", time.getCodigo());
        contentValues.put("nome", time.getNome());
        contentValues.put("cidade", time.getCidade());

        return contentValues;
    }
}
