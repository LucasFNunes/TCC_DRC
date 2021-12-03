package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaCoco;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaGas;
import com.example.tcc_drc.ui.activities.infonutriBebidas.Cerveja;
import com.example.tcc_drc.ui.activities.infonutriBebidas.SucoIndust;
import com.example.tcc_drc.ui.activities.infonutriLeite.CremedeLeite;
import com.example.tcc_drc.ui.activities.infonutriLeite.Iogurte;
import com.example.tcc_drc.ui.activities.infonutriLeite.LeiteCoco;
import com.example.tcc_drc.ui.activities.infonutriLeite.LeiteIntegral;
import com.example.tcc_drc.ui.activities.infonutriLeite.LeiteemPo;
import com.example.tcc_drc.ui.activities.infonutriLeite.QueijoMinas;
import com.example.tcc_drc.ui.activities.infonutriLeite.Ricota;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Leite extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_leite);
        listViewDados = (ListView) findViewById(R.id.listViewDados);
        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria7(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome VARCHAR)");
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria7", null );
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
                    Intent intent = new Intent(view.getContext(), CremedeLeite.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(), Iogurte.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(), LeiteCoco.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(view.getContext(), LeiteemPo.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(view.getContext(), LeiteIntegral.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(view.getContext(), QueijoMinas.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(view.getContext(), Ricota.class);
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
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria7(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria7)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            String sql="INSERT INTO Categoria7 (nome) VALUES(?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);

            stmt.bindString(1,"Creme de leite");
            stmt.executeInsert();

            stmt.bindString(1,"Iogurte natural");
            stmt.executeInsert();

            stmt.bindString(1,"Leite de coco");
            stmt.executeInsert();

            stmt.bindString(1,"Leite em pó");
            stmt.executeInsert();

            stmt.bindString(1,"Leite integral");
            stmt.executeInsert();

            stmt.bindString(1,"Queijo minas");
            stmt.executeInsert();

            stmt.bindString(1,"Ricota");
            stmt.executeInsert();


            bancoDados.close();
            listarDados();

        }catch (Exception e){
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria7", null );
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