package com.example.tcc_drc.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tcc_drc.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


    }
    public void onClickBebidas(View view) {
        Intent intent = new Intent(this, Bebidas.class);
        startActivity(intent);
    }
    public void onClickCereais(View view) {
        Intent intent = new Intent(this, Cereais.class);
        startActivity(intent);
    }
    public void onClickDoces(View view) {
        Intent intent = new Intent(this, Doces.class);
        startActivity(intent);
    }
    public void onClickEmbutidos(View view) {
        Intent intent = new Intent(this, Embutidos.class);
        startActivity(intent);
    }
    public void onClickEnlatados(View view) {
        Intent intent = new Intent(this, Enlatados.class);
        startActivity(intent);
    }
    public void onClickIndustrializados(View view) {
        Intent intent = new Intent(this, Industrializados.class);
        startActivity(intent);
    }
    public void onClickLegumes(View view) {
        Intent intent = new Intent(this, Legumes.class);
        startActivity(intent);
    }
    public void onClickLeite(View view) {
        Intent intent = new Intent(this, Leite.class);
        startActivity(intent);
    }
    public void onClickOleos(View view) {
        Intent intent = new Intent(this, Oleos.class);
        startActivity(intent);
    }
    public void onClickTemperos(View view) {
        Intent intent = new Intent(this, Temperos.class);
        startActivity(intent);
    }
    public void onClickFrutas(View view) {
        Intent intent = new Intent(this, Frutas.class);
        startActivity(intent);
    }
    public void onClickSobre(View view) {
        Intent intent = new Intent(this, Sobre.class);
        startActivity(intent);
    }
}