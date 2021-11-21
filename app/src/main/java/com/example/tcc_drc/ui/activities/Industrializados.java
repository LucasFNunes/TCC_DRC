package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaCoco;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaGas;
import com.example.tcc_drc.ui.activities.infonutriBebidas.Cerveja;
import com.example.tcc_drc.ui.activities.infonutriBebidas.SucoIndust;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Achocolatado;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Cafe;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.ExtraTomate;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Farofa;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Gelatina;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Macarrao;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.MacarraoInsta;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Maionese;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.MisturaBolo;
import com.example.tcc_drc.ui.activities.infonutriIndustrializados.Pipoca;

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

public class Industrializados extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    public ListView listViewDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industrializados);
        listViewDados = (ListView) findViewById(R.id.listViewDados);
        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria5(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome VARCHAR)");
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria5", null );
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
                    Intent intent = new Intent(view.getContext(), Achocolatado.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(), Cafe.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(), ExtraTomate.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(view.getContext(), Farofa.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(view.getContext(), Gelatina.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(view.getContext(), Macarrao.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(view.getContext(), MacarraoInsta.class);
                    startActivity(intent);
                }
                if(position == 7){
                    Intent intent = new Intent(view.getContext(), Maionese.class);
                    startActivity(intent);
                }
                if(position == 8){
                    Intent intent = new Intent(view.getContext(), MisturaBolo.class);
                    startActivity(intent);
                }
                if(position == 9){
                    Intent intent = new Intent(view.getContext(), Pipoca.class);
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
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria5(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria5)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
        try {
            bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
            String sql="INSERT INTO Categoria5 (nome) VALUES(?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);

            stmt.bindString(1,"Achocolatado");
            stmt.executeInsert();

            stmt.bindString(1,"Café");
            stmt.executeInsert();

            stmt.bindString(1,"Extrato de tomate");
            stmt.executeInsert();

            stmt.bindString(1,"Farofa");
            stmt.executeInsert();

            stmt.bindString(1,"Gelatina");
            stmt.executeInsert();

            stmt.bindString(1,"Macarrão ");
            stmt.executeInsert();

            stmt.bindString(1,"Macarrão instantâneo");
            stmt.executeInsert();

            stmt.bindString(1,"Maionese");
            stmt.executeInsert();

            stmt.bindString(1,"Mistura para bolo");
            stmt.executeInsert();

            stmt.bindString(1,"Pipoca");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria5", null );
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