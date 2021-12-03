package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaCoco;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaGas;
import com.example.tcc_drc.ui.activities.infonutriBebidas.Cerveja;
import com.example.tcc_drc.ui.activities.infonutriBebidas.RefriCola;
import com.example.tcc_drc.ui.activities.infonutriBebidas.RefriGuarana;
import com.example.tcc_drc.ui.activities.infonutriBebidas.RefriLaranja;
import com.example.tcc_drc.ui.activities.infonutriBebidas.SucoIndust;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bebidas extends AppCompatActivity {

    private SQLiteDatabase bancoDados;

    public ListView listViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_bebidas);

        listViewDados = (ListView) findViewById(R.id.listViewDados);



        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome VARCHAR)");
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria", null );
        ArrayList<String> linhas = new ArrayList <String>();
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                linhas
        );

        listViewDados.setAdapter(adapter);
        listViewDados.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(position == 0){
                    Intent intent = new Intent(view.getContext(), AguaGas.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(), AguaCoco.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(), Cerveja.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(view.getContext(), RefriCola.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(view.getContext(), RefriLaranja.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(view.getContext(), RefriGuarana.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(view.getContext(), SucoIndust.class);
                    startActivity(intent);
                }
            }
        });
        bancoDados.close();
        deleteDatabase("crudeapp");
        criarBancoDados();
    }

    public void criarBancoDados(){


        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome VARCHAR)");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        inserirDadosTemp();

    }

    public void inserirDadosTemp() {
        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Categoria (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Água com gás ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Água de coco");
                    stmt.executeInsert();

                    stmt.bindString(1, "Cerveja");
                    stmt.executeInsert();

                    stmt.bindString(1, "Refrigerante Cola");
                    stmt.executeInsert();

                    stmt.bindString(1, "Refrigerante Laranja");
                    stmt.executeInsert();

                    stmt.bindString(1, "Refrigerante Guaraná");
                    stmt.executeInsert();

                    stmt.bindString(1, "Suco industrializado");
                    stmt.executeInsert();



                    bancoDados.close();
                    listarDados();

                } catch (Exception e) {
                    e.printStackTrace();

                }
            } else {
                listarDados();
            }
        }
    }

    public void listarDados(){
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria", null );
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
