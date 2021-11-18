package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaGas;

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

public class Doces extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doces);
        listViewDados = (ListView) findViewById(R.id.listViewDados);


        criarBancoDados();

    }

    public void criarBancoDados() {

            try {

                bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria2(" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                        ", nome VARCHAR)");
                bancoDados.close();



            } catch (Exception e) {
                e.printStackTrace();
            }
            inserirDadosTemp();

    }
    public void inserirDadosTemp(){
        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria2)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Categoria2 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Chocolate meio amargo");
                    stmt.executeInsert();

                    stmt.bindString(1, "Doce de leite");
                    stmt.executeInsert();

                    stmt.bindString(1, "Doce de pêssego");
                    stmt.executeInsert();

                    stmt.bindString(1, "Maria mole");
                    stmt.executeInsert();

                    bancoDados.close();
                    listarDados();

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }else{
                    listarDados();
                }
            }
        }
    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria2", null );
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
    public void onClickAguaGas(View view) {
        Intent intent = new Intent(this, AguaGas.class);
        startActivity(intent);
    }
    public void onClickAguaCoco(View view) {
        Intent intent = new Intent(this, AguaGas.class);
        startActivity(intent);
    }
    public void onClickCerveja(View view) {
        Intent intent = new Intent(this, AguaGas.class);
        startActivity(intent);
    }
    public void onClickSucoIndust(View view) {
        Intent intent = new Intent(this, AguaGas.class);
        startActivity(intent);
    }
}