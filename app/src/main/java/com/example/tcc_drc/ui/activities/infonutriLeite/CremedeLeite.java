package com.example.tcc_drc.ui.activities.infonutriLeite;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.Legumes;
import com.example.tcc_drc.ui.activities.Leite;

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

public class CremedeLeite extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_cremede_leite);
        listViewDados = (ListView) findViewById(R.id.listViewDados);

        criarBancoDados();
    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos43(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos43)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos43 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informa????o Nutricional: Creme de Leite");
                    stmt.executeInsert();

                    stmt.bindString(1, "Por????o: 1 1/2 colher de sopa 15g ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Valor energ??tico (Kcal): 33,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 0,7");
                    stmt.executeInsert();

                    stmt.bindString(1, "A????cares (g): 0,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Prote??nas (g): 0,2");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 3,4");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 1,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 0 ");
                    stmt.executeInsert();

                    stmt.bindString(1, "S??dio (mg): 7,7");
                    stmt.executeInsert();

                    stmt.bindString(1, "F??sforo (mg): 17,8");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pot??ssio (mg); 17,8");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos43", null );
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
        Intent intent = new Intent(this, Leite.class);
        startActivity(intent);
    }
}