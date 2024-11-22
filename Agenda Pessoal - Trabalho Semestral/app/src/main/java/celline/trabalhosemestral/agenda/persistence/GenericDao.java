package celline.trabalhosemestral.agenda.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE = "AgendaDB";
    private static final int DATABASE_VER = 2;
    private static final String CREATE_TABLE_COMPROMISSOS =
            "CREATE TABLE compromissos (" +
                    "id INT NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(80) NOT NULL," +
                    "data CHAR(10) NOT NULL," +
                    "hora CHAR(8) NOT NULL," +
                    "obs VARCHAR(120));";
    private static final String CREATE_TABLE_TAREFAS =
            "CREATE TABLE tarefas (" +
                    "id INT NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "data CHAR(10) NOT NULL," +
                    "hora CHAR(8) NOT NULL," +
                    "tipoTarefa VARCHAR(20)," +
                    "idDisciplina INT NOT NULL," +
                    "FOREIGN KEY (idDisciplina) REFERENCES disciplina(id));";
    private static final String CREATE_TABLE_DISCIPLINAS =
            "CREATE TABLE disciplinas (" +
                    "id INT NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(50) NOT NULL);";

    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_COMPROMISSOS);
        sqLiteDatabase.execSQL(CREATE_TABLE_TAREFAS);
        sqLiteDatabase.execSQL(CREATE_TABLE_DISCIPLINAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigaVersao, int novaVersao) {
        if (novaVersao > antigaVersao){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS compromissos");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tarefas");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS disciplinas");
            onCreate(sqLiteDatabase);
        }
    }
}
