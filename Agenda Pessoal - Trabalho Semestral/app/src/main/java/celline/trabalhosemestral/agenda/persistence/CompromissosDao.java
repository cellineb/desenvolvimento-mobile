package celline.trabalhosemestral.agenda.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Compromissos;
import celline.trabalhosemestral.agenda.model.Disciplina;

public class CompromissosDao implements ICompromissosDao, ICRUDDao<Compromissos> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public CompromissosDao(Context context) {
        this.context = context;
    }

    @Override
    public CompromissosDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Compromissos compromissos) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(compromissos);
        database.insert("compromissos", null, contentValues);
        close();
    }

    @Override
    public int update(Compromissos compromissos) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(compromissos);
        int ret = database.update("compromissos", contentValues, "id =" + compromissos.getId(), null);
        close();
        return ret;
    }

    @Override
    public void delete(Compromissos compromissos) throws SQLException {
        open();
        database.delete("compromissos", "id =" + compromissos.getId(), null);
        close();
    }

    @SuppressLint("Range")
    @Override
    public Compromissos findOne(Compromissos compromissos) throws SQLException {
        open();
        String sql = "SELECT * FROM compromissos WHERE id =" + compromissos.getId();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){

            compromissos.setId(cursor.getInt(cursor.getColumnIndex("id")));
            compromissos.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            compromissos.setData(cursor.getString(cursor.getColumnIndex("data")));
            compromissos.setHora(cursor.getString(cursor.getColumnIndex("hora")));
            compromissos.setObs(cursor.getString(cursor.getColumnIndex("obs")));
        }
        cursor.close();
        close();
        return compromissos;
    }

    @SuppressLint("Range")
    @Override
    public List<Compromissos> findAll() throws SQLException {
        open();
        List<Compromissos> compromissos = new ArrayList<>();
        String sql = "SELECT * FROM compromissos";
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Compromissos c = new Compromissos();

                c.setId(cursor.getInt(cursor.getColumnIndex("id")));
                c.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                c.setData(cursor.getString(cursor.getColumnIndex("data")));
                c.setHora(cursor.getString(cursor.getColumnIndex("hora")));
                c.setObs(cursor.getString(cursor.getColumnIndex("obs")));

                compromissos.add(c);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        close();
        return compromissos;
    }

    private ContentValues getContentValues(Compromissos compromissos) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", compromissos.getId());
        contentValues.put("nome", compromissos.getNome());
        contentValues.put("data", String.valueOf(compromissos.getData()));
        contentValues.put("hora", compromissos.getHora());
        contentValues.put("obs", compromissos.getObs());

        return contentValues;
    }
}
