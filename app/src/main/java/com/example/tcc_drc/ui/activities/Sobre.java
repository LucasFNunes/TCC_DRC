package com.example.tcc_drc.ui.activities;

import com.example.tcc_drc.R;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sobre);

        TextView t2 = (TextView) findViewById(R.id.text2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void onClickVoltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}