package com.example.tcc_drc.ui.activities.infonutriBebidas;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.Bebidas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AguaGas extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_agua_gas);
        listViewDados = (ListView) findViewById(R.id.listViewDados);



        criarBancoDados();
    }

    public void criarBancoDados(){

            try {

                bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Produtos(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Produtos)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Produtos (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Informa????o Nutricional: ??gua com g??s");
                    stmt.executeInsert();

                    stmt.bindString(1, "Por????o: 1 copo - 200 mL ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Valor energ??tico (Kcal): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Carboidratos (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "A????cares (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Prote??nas (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras totais (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras saturadas (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Gorduras trans (g): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Fibra Alimentar (g): 0 ");
                    stmt.executeInsert();

                    stmt.bindString(1, "S??dio (mg): 10,92");
                    stmt.executeInsert();

                    stmt.bindString(1, "F??sforo (mg): 0");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pot??ssio (mg); 0,2768");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Produtos", null );
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
        Intent intent = new Intent(this, Bebidas.class);
        startActivity(intent);
    }
}