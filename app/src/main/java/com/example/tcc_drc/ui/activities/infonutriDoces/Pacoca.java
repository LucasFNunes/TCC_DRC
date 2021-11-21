package com.example.tcc_drc.ui.activities.infonutriDoces;

import com.example.tcc_drc.R;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Pacoca extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacoca);
        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos22(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome VARCHAR)");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        inserirDadosTemp();

    }

    public void inserirDadosTemp() {

        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos22)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos22 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informação Nutricional: Paçoca");
                    stmt.executeInsert();

                    stmt.bindString(1, "Porção: 1 unidade 20g ");
                    stmt.executeInsert();


                    stmt.bindString(1, "Valor energético (Kcal): 97,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 10,5");
                    stmt.executeInsert();

                    stmt.bindString(1, "Açúcares (g): 3");
                    stmt.executeInsert();

                    stmt.bindString(1, "Proteínas (g): 3,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 5,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 0,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 1,5 ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Sódio (mg): 33,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fósforo (mg): 39,7");
                    stmt.executeInsert();

                    stmt.bindString(1, "Potássio (mg); 69,5");
                    stmt.executeInsert();
                    bancoDados.close();
                    listarDados();

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
            else{
                bancoDados.close();
                listarDados();
            }

        }
    }
    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos22", null );
            ArrayList<String> linhas = new ArrayList <String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    linhas
            );
            listViewDados.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while(meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                meuCursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}