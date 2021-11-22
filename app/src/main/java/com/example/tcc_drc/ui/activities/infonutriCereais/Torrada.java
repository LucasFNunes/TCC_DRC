package com.example.tcc_drc.ui.activities.infonutriCereais;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.Cereais;

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

public class Torrada extends AppCompatActivity {

    private SQLiteDatabase bancoDados;

    public ListView listViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torrada);
        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos14(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos14)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos14 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informação Nutricional: Torrada ");
                    stmt.executeInsert();

                    stmt.bindString(1, " Porção: 4 unidades 30g");
                    stmt.executeInsert();

                    stmt.bindString(1, "Valor energético (Kcal): 113,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 22,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Açúcares (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Proteínas (g): 3,1");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 1");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 0,3");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 1");
                    stmt.executeInsert();

                    stmt.bindString(1, "Sódio (mg): 248,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fósforo (mg): 34,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Potássio (mg); 56,8");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos14", null );
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
        Intent intent = new Intent(this, Cereais.class);
        startActivity(intent);
    }
}