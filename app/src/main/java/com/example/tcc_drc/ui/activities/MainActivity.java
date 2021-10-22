package com.example.tcc_drc.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tcc_drc.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Bebi = (Button) findViewById(R.id.bebidas);
        Button Cere = (Button) findViewById(R.id.cereais);
        Button Doce = (Button) findViewById(R.id.doces);
        Button Embut = (Button) findViewById(R.id.embutidos);
        Button Indust = (Button) findViewById(R.id.industria);
        Button Enlat = (Button) findViewById(R.id.enlatados);
        Button Leg = (Button) findViewById(R.id.legumes);
        Button Leit = (Button) findViewById(R.id.leite);
        Button Oleo = (Button) findViewById(R.id.oleos);
        Button Temp = (Button) findViewById(R.id.temperos);

        Bebi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Bebidas.class);
                startActivity(it);
            }
        });
        Cere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Cereais.class);
                startActivity(it);
            }
        });
        Doce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Doces.class);
                startActivity(it);
            }
        });
        Embut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Embutidos.class);
                startActivity(it);
            }
        });
        Indust.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Industrializados.class);
                startActivity(it);
            }
        });
        Enlat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Enlatados.class);
                startActivity(it);
            }
        });
        Leg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Legumes.class);
                startActivity(it);
            }
        });
        Leit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Leite.class);
                startActivity(it);
            }
        });
        Oleo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Oleos.class);
                startActivity(it);
            }
        });
        Temp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Temperos.class);
                startActivity(it);
            }
        });

    }


}