package celline.trabalhosemestral.agenda.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import celline.trabalhosemestral.agenda.model.Tarefas;

public class TarefasDao implements ITarefasDao, ICRUDDao<Tarefas> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public TarefasDao(Context context) {
        this.context = context;
    }

    @Override
    public TarefasDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Tarefas tarefas) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(tarefas);
        database.insert("tarefas", null, contentValues);
        close();
    }

    @Override
    public int update(Tarefas tarefas) throws SQLException {
        open();
        ContentValues contentValues = getContentValues(tarefas);
        int ret = database.update("tarefas", contentValues, "id =" + tarefas.getId(), null);
        close();
        return ret;
    }

    @Override
    public void delete(Tarefas tarefas) throws SQLException {
        open();
        database.delete("tarefas", "id =" + tarefas.getId(), null);
        close();
    }

    @SuppressLint("Range")
    @Override
    public Tarefas findOne(Tarefas tarefas) throws SQLException {
        open();
        String sql = "SELECT * FROM tarefas WHERE id =" + tarefas.getId();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){

            tarefas.setId(cursor.getInt(cursor.getInt(Integer.parseInt("id"))));
            tarefas.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            tarefas.setData(cursor.getString(cursor.getColumnIndex("data")));
            tarefas.setHora(cursor.getString(cursor.getColumnIndex("hora")));
            tarefas.setTipoTarefa(cursor.getString(cursor.getColumnIndex("tipoTarefa")));
        }
        cursor.close();
        close();
        return tarefas;
    }

    @SuppressLint("Range")
    @Override
    public List<Tarefas> findAll() throws SQLException {
        open();
        List<Tarefas> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){
            Tarefas t = new Tarefas();

            t.setId(cursor.getInt(cursor.getInt(Integer.parseInt("id"))));
            t.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            t.setData(cursor.getString(cursor.getColumnIndex("data")));
            t.setHora(cursor.getString(cursor.getColumnIndex("hora")));
            t.setTipoTarefa(cursor.getString(cursor.getColumnIndex("tipoTarefa")));

            tarefas.add(t);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return tarefas;
    }

    private ContentValues getContentValues(Tarefas tarefas) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", tarefas.getId());
        contentValues.put("nome", tarefas.getNome());
        contentValues.put("data", String.valueOf(tarefas.getData()));
        contentValues.put("hora", tarefas.getHora());
        contentValues.put("tipoTarefa", tarefas.getTipoTarefa());

        return contentValues;
    }
}
