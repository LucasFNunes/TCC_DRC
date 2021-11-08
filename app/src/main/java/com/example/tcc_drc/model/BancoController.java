package com.example.tcc_drc.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tcc_drc.data.CriaBancoProduto;
import com.example.tcc_drc.data.CriaBancoCategoria;
import android.content.ContentValues;
import android.content.Context;

public class BancoController {
/*
    private SQLiteDatabase db;
    private CriaBancoCategoria banco;
    private CriaBancoProduto banco2;

    public BancoController(Context context){
        banco = new CriaBancoCategoria(context);
    }

    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBancoCategoria.ID, titulo);
        valores.put(CriaBancoCategoria.NOME, autor);

        resultado = db.insert(CriaBancoCategoria.TABELA, null, valores);
        db.close();
}
        public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = {banco.ID, banco.NOME};

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

 */
}