package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaCoco;
import com.example.tcc_drc.ui.activities.infonutriBebidas.AguaGas;
import com.example.tcc_drc.ui.activities.infonutriBebidas.Cerveja;
import com.example.tcc_drc.ui.activities.infonutriBebidas.SucoIndust;
import com.example.tcc_drc.ui.activities.infonutriCereais.Aveia;
import com.example.tcc_drc.ui.activities.infonutriCereais.BiscoitoPolvilho;
import com.example.tcc_drc.ui.activities.infonutriCereais.Biscoitoagua;
import com.example.tcc_drc.ui.activities.infonutriCereais.Biscoitorecheado;
import com.example.tcc_drc.ui.activities.infonutriCereais.Cereal;
import com.example.tcc_drc.ui.activities.infonutriCereais.PaoFrances;
import com.example.tcc_drc.ui.activities.infonutriCereais.PaodeForma;
import com.example.tcc_drc.ui.activities.infonutriCereais.Torrada;

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

public class Cereais extends AppCompatActivity{


    private SQLiteDatabase bancoDados;

    public ListView listViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_cereais);

        listViewDados = (ListView) findViewById(R.id.listViewDados);


        bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria1(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", nome VARCHAR)");
        Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria1", null );
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
                    Intent intent = new Intent(view.getContext(), Aveia.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(), Biscoitoagua.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(), BiscoitoPolvilho.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(view.getContext(), Biscoitorecheado.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(view.getContext(), Cereal.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(view.getContext(), PaodeForma.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(view.getContext(), PaoFrances.class);
                    startActivity(intent);
                }
                if(position == 7){
                    Intent intent = new Intent(view.getContext(), Torrada.class);
                    startActivity(intent);
                }
            }
        });
        bancoDados.close();

        criarBancoDados();


    }

    public void criarBancoDados() {

            try {

                bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Categoria1(" +
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
        Cursor cur = bancoDados.rawQuery("SELECT EXISTS (SELECT 1 FROM Categoria1)", null);


        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                try {
                    bancoDados = openOrCreateDatabase("crudeapp", MODE_PRIVATE, null);
                    String sql = "INSERT INTO Categoria1 (nome) VALUES(?)";
                    SQLiteStatement stmt = bancoDados.compileStatement(sql);

                    stmt.bindString(1, "Aveia");
                    stmt.executeInsert();

                    stmt.bindString(1, "Biscoito água e sal");
                    stmt.executeInsert();

                    stmt.bindString(1, "Biscoito polvilho doce");
                    stmt.executeInsert();

                    stmt.bindString(1, "Biscoito recheado");
                    stmt.executeInsert();

                    stmt.bindString(1, "Cereal");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pão de forma integral");
                    stmt.executeInsert();

                    stmt.bindString(1, "Pão francês ");
                    stmt.executeInsert();

                    stmt.bindString(1, "Torrada");
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
            Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome FROM Categoria1", null );
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