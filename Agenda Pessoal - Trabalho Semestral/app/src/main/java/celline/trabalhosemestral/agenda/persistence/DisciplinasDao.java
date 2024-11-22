package celline.trabalhosemestral.agenda.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Compromissos;
import celline.trabalhosemestral.agenda.model.Disciplina;

public class DisciplinasDao implements IDisciplinasDao, ICRUDDao<Disciplina> {
    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public DisciplinasDao(Context context) {
        this.context = context;
    }

    @Override
    public DisciplinasDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Disciplina disciplina) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(disciplina);
        database.insert("disciplinas",null, contentValues);
        close();
    }

    @Override
    public int update(Disciplina disciplina) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(disciplina);
        int ret = database.update("disciplinas", contentValues, "id =" + disciplina.getId(), null);
        close();
        return ret;
    }

    @Override
    public void delete(Disciplina disciplina) throws SQLException {
        open();
        database.delete("disciplinas", "id =" + disciplina.getId(), null);
        close();
    }

    @SuppressLint("Range")
    @Override
    public Disciplina findOne(Disciplina disciplina) throws SQLException {
        open();
        String sql = "SELECT * FROM disciplinas WHERE id =" + disciplina.getId();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){

            disciplina.setId(cursor.getInt(cursor.getColumnIndex("id")));
            disciplina.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        }
        cursor.close();
        close();
        return disciplina;
    }


    @SuppressLint("Range")
    @Override
    public List<Disciplina> findAll() throws SQLException {
        open();
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM disciplinas";
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Disciplina d = new Disciplina();

                d.setId(cursor.getInt(cursor.getColumnIndex("id")));
                d.setNome(cursor.getString(cursor.getColumnIndex("nome")));

                disciplinas.add(d);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        close();
        return disciplinas;
    }


    private ContentValues getContentValues(Disciplina disciplina) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", disciplina.getId());
        contentValues.put("nome", disciplina.getNome());

        return contentValues;
    }
}