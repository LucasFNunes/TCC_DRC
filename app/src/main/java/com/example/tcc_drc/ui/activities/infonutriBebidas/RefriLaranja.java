package com.example.tcc_drc.ui.activities.infonutriBebidas;

import com.example.tcc_drc.R;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RefriLaranja extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refri_laranja);
        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos5(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos5)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos5 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informação Nutricional: Refrigerante Laranja");
                    stmt.executeInsert();

                    stmt.bindString(1, "Porção: 1 copo - 200 mL ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Valor energético (Kcal): 91,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 23,6");
                    stmt.executeInsert();

                    stmt.bindString(1, "Açúcares (g): 23,6");
                    stmt.executeInsert();

                    stmt.bindString(1, "Proteínas (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 0 ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Sódio (mg): 18,5");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fósforo (mg): 2,9");
                    stmt.executeInsert();

                    stmt.bindString(1, "Potássio (mg); 31");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos5", null );
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