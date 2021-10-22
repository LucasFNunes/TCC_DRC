package com.example.tcc_drc.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.content.Context;
import io.realm.Realm;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "Categorias";
    private static final String TABELA1 = "Produtos";
    private static final int ID = 1;
    private static final String NOME = "nome";
    private static final String NOME1 = "nome";
    private static final String AVALIACAO = "avaliacao";
    private static final int CATEGORIA_ID = 1;
    private static final int VERSAO = 1;
    private static final int VALOR = 1;
    private static final String CARBO = "carboidratos";
    private static final String ACUCAR = "açucares";
    private static final String PROTEINA = "proteina";
    private static final String GORDURASTOTAIS = "gorduras totais";
    private static final String GORDURASSAT = "gorduras saturadas";
    private static final String GORDURASTRANS = "gorduras trans";
    private static final String FIBRA = "fibras";
    private static final String SODIO = "sódio";
    private static final String FOSFORO = "fósforo";
    private static final String POTASSIO = "potassio";

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text"
                +")";

        String bd = "CREATE TABLE"+TABELA1+"("
                + ID + " integer primary key autoincrement,"
                + NOME1 + " text,"
                + AVALIACAO + " text,"
                + CATEGORIA_ID + " integer"
                + VALOR + " integer"
                + CARBO + " text,"
                + ACUCAR + " text,"
                + PROTEINA + " text,"
                + GORDURASTOTAIS + " text,"
                + GORDURASSAT + " text,"
                + GORDURASTRANS + " text,"
                + FIBRA + " text,"
                + SODIO + " text,"
                + FOSFORO + " text,"
                + POTASSIO + " text"
                +")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }
}