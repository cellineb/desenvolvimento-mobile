package celline.lista08.timejogador.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 *@author: Celline
 */
public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE = "timeDB";
    private static final int DATABASE_VER = 1;
    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE time (" +
                    "codigo INT NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(80) NOT NULL," +
                    "cidade VARCHAR(150) NOT NULL);";
    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE jogador (" +
                    "id INT NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "dataNasc CHAR(10) NOT NULL," +
                    "altura CHAR(5) NOT NULL," +
                    "peso CHAR(5) NOT NULL," +
                    "codTime INT NOT NULL," +
                    "FOREIGN KEY (codTime) REFERENCES time(codigo));";

    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TIME);
        sqLiteDatabase.execSQL(CREATE_TABLE_JOGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigaVersao, int novaVersao) {
        if (novaVersao > antigaVersao){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS time");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS jogador");
            onCreate(sqLiteDatabase);
        }
    }
}
