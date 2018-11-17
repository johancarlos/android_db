package com.example.estudiante.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseOpenHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "Usuarios.db"
        val DATABASE_VERSION = 1;
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DataBaseContract.UsuarioEntry.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun saveUser(userName: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(DataBaseContract.UsuarioEntry.COLUMN_USER_NAME, userName)
        db.insert(DataBaseContract.UsuarioEntry.TABLE_NAME, null, values)
        db.close()
    }

    fun getUsers() : List<String> {
        val lista: ArrayList<String> = ArrayList<String>()
        val query = "SELECT * FROM ${DataBaseContract.UsuarioEntry.TABLE_NAME}"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(1))
            } while (cursor.moveToNext())
        }

        return lista
    }
}
