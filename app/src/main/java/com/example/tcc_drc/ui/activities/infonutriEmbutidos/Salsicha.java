package com.example.tcc_drc.ui.activities.infonutriEmbutidos;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.Embutidos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Salsicha extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_salsicha);
        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos25(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome VARCHAR)");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        inserirDadosTemp();


    }

    public void inserirDadosTemp(){

        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos25)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos25 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informação Nutricional: Salsicha");
                    stmt.executeInsert();

                    stmt.bindString(1, "Porção: 1 unidade 50g ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Valor energético (Kcal): 160,5");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 1,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Açúcares (g): 1,6");
                    stmt.executeInsert();

                    stmt.bindString(1, "Proteínas (g): 4,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 14,7");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 5,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 0 ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Sódio (mg): 587,3");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fósforo (mg): 39,3");
                    stmt.executeInsert();

                    stmt.bindString(1, "Potássio (mg); 54,4");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos25", null );
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
    public void onClickVoltar(View view) {
        Intent intent = new Intent(this, Embutidos.class);
        startActivity(intent);
    }
}