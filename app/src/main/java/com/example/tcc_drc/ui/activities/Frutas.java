package com.example.tcc_drc.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Abacate;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Abacaxi;
import com.example.tcc_drc.ui.activities.infonutriFrutas.BananaMaca;
import com.example.tcc_drc.ui.activities.infonutriFrutas.BananaPrata;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Laranja;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Maca;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Mamao;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Manga;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Maracuja;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Melao;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Morango;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Pera;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Pessego;
import com.example.tcc_drc.ui.activities.infonutriFrutas.Uva;

import java.util.ArrayList;

public class Frutas extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_frutas);
        listViewDados = (ListView) findViewById(R.id.listViewDados);
        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria16(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome VARCHAR)");
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria16", null );
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
                    Intent intent = new Intent(view.getContext(), Abacate.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(), Abacaxi.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(), BananaMaca.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(view.getContext(), BananaPrata.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(view.getContext(), Laranja.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(view.getContext(), Maca.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(view.getContext(), Mamao.class);
                    startActivity(intent);
                }
                if(position == 7){
                    Intent intent = new Intent(view.getContext(), Manga.class);
                    startActivity(intent);
                }
                if(position == 8){
                    Intent intent = new Intent(view.getContext(), Maracuja.class);
                    startActivity(intent);
                }
                if(position == 9){
                    Intent intent = new Intent(view.getContext(), Melao.class);
                    startActivity(intent);
                }
                if(position == 10){
                    Intent intent = new Intent(view.getContext(), Morango.class);
                    startActivity(intent);
                }
                if(position == 11){
                    Intent intent = new Intent(view.getContext(), Pera.class);
                    startActivity(intent);
                }
                if(position == 12){
                    Intent intent = new Intent(view.getContext(), Pessego.class);
                    startActivity(intent);
                }
                if(position == 13){
                    Intent intent = new Intent(view.getContext(), Uva.class);
                    startActivity(intent);
                }
            }
        });
        bancoDados.close();
        criarBancoDados();


    }

    public void criarBancoDados(){

        try {

            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria16(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria16)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Categoria16 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Abacate");
                    stmt.executeInsert();

                    stmt.bindString(1, "Abacaxi");
                    stmt.executeInsert();

                    stmt.bindString(1, "Banana Maçã");
                    stmt.executeInsert();

                    stmt.bindString(1, "Banana Prata");
                    stmt.executeInsert();

                    stmt.bindString(1, "Laranja");
                    stmt.executeInsert();

                    stmt.bindString(1, "Maçã");
                    stmt.executeInsert();

                    stmt.bindString(1, "Mamão");
                    stmt.executeInsert();

                    stmt.bindString(1, "Manga");
                    stmt.executeInsert();

                    stmt.bindString(1, "Maracujá");
                    stmt.executeInsert();

                    stmt.bindString(1, "Melão");
                    stmt.executeInsert();

                    stmt.bindString(1, "Morango");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pêra");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pessego");
                    stmt.executeInsert();

                    stmt.bindString(1, "Uva");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria16", null );
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