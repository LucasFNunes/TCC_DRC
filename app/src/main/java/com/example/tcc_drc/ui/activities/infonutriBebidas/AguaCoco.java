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

public class AguaCoco extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua_coco);
        listViewDados = (ListView) findViewById(R.id.listViewDados);


        criarBancoDados();
    }

    public void criarBancoDados(){

        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos1", null);
        ArrayList<String> linhas = new ArrayList<String>();
        ArrayAdapter meuAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                linhas
        );
        listViewDados.setAdapter(meuAdapter);
        meuCursor.moveToFirst();
        if (meuCursor == null) {
            try {

                bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos1(" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                        ", nome VARCHAR)");
                bancoDados.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            inserirDadosTemp();

        }else {
            listarDados();
        }
    }

    public void inserirDadosTemp(){
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            String sql="INSERT INTO Produtos1 (nome) VALUES(?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);

            stmt.bindString(1,"Porção: Água de Coco ");
            stmt.executeInsert();

            stmt.bindString(1,"Informação Nutricional: 1 copo - 200 mL");
            stmt.executeInsert();

            stmt.bindString(1,"Valor energético (Kcal): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Carboidratos (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Açúcares (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Proteínas (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Gorduras totais (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Gorduras saturadas (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Gorduras trans (g): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Fibra Alimentar (g): 0 ");
            stmt.executeInsert();

            stmt.bindString(1,"Sódio (mg): 10,92");
            stmt.executeInsert();

            stmt.bindString(1,"Fósforo (mg): 0");
            stmt.executeInsert();

            stmt.bindString(1,"Potássio (mg); 0,2768");
            stmt.executeInsert();
            bancoDados.close();

        }catch (Exception e){
            e.printStackTrace();

        }
        listarDados();
    }
    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos1", null );
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