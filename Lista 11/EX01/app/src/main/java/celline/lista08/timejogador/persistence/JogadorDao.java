package celline.lista08.timejogador.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import celline.lista08.timejogador.model.Jogador;
import celline.lista08.timejogador.model.Time;

/*
 *@author: Celline
 */
public class JogadorDao implements IJogadorDao, ICRUDDao<Jogador> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public JogadorDao(Context context) {
        this.context = context;
    }

    @Override
    public JogadorDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        database.insert("time", null, contentValues);
    }

    @Override
    public int update(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        int ret = database.update("jogador", contentValues, "codigo =" + jogador.getId(), null);
        return ret;
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        database.delete("jogador", "codigo =" + jogador.getId(), null);
    }

    @SuppressLint("Range")
    @Override
    public Jogador findOne(Jogador jogador) throws SQLException {
        String sql = "SELECT t.codigo AS cod_time, t.nome AS nome_time, t.cidade AS cidade_time, " +
                "j.id, j.nome, j.dataNasc, j.altura, j.peso " +
                "FROM time t, jogador j " +
                "WHERE t.codigo = j.codTime" +
                "AND j.id = " + jogador.getId();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){
            Time time = new Time();
            time.setCodigo(cursor.getInt(cursor.getColumnIndex("cod_time")));
            time.setNome(cursor.getString(cursor.getColumnIndex("nome_time")));
            time.setCidade(cursor.getString(cursor.getColumnIndex("cidade_time")));

            jogador.setId(cursor.getInt(cursor.getColumnIndex("id")));
            jogador.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            jogador.setDataNasc(LocalDate.parse(cursor.getString(cursor.getColumnIndex("dataNasc"))));
            jogador.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            jogador.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            jogador.setCodTime(time);
        }
        cursor.close();
        return jogador;
    }

    @SuppressLint("Range")
    @Override
    public List<Jogador> findAll() throws SQLException {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT t.codigo AS cod_time, t.nome AS nome_time, t.cidade AS cidade_time, " +
                "j.id, j.nome, j.dataNasc, j.altura, j.peso " +
                "FROM time t, jogador j " +
                "WHERE t.codigo = j.codTime";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()){
            Jogador j = new Jogador();
            Time time = new Time();
            time.setCodigo(cursor.getInt(cursor.getColumnIndex("cod_time")));
            time.setNome(cursor.getString(cursor.getColumnIndex("nome_time")));
            time.setCidade(cursor.getString(cursor.getColumnIndex("cidade_time")));

            j.setId(cursor.getInt(cursor.getColumnIndex("id")));
            j.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            j.setDataNasc(LocalDate.parse(cursor.getString(cursor.getColumnIndex("dataNasc"))));
            j.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            j.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            j.setCodTime(time);

            jogadores.add(j);
            cursor.moveToNext();
        }
        cursor.close();
        return jogadores;
    }

    public static ContentValues getContentValues(Jogador jogador){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", jogador.getId());
        contentValues.put("nome", jogador.getNome());
        contentValues.put("dataNasc", String.valueOf(jogador.getDataNasc()));
        contentValues.put("altura", jogador.getAltura());
        contentValues.put("peso", jogador.getPeso());
        contentValues.put("codTime", jogador.getCodTime().getCodigo());

        return contentValues;
    }
}
