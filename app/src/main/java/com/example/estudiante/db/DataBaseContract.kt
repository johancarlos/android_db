package com.example.estudiante.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DataBaseContract {

    class UsuarioEntry: BaseColumns {
        companion object {
            val TABLE_NAME = "usuarios"
            val COLUMN_USER_ID = "id"
            val COLUMN_USER_NAME = "nombre"
            val SQL_CREATE_TABLE = "CREATE TABLE ${TABLE_NAME} (${COLUMN_USER_ID} INTEGER PRIMARY KEY, ${COLUMN_USER_NAME} TEXT NOT NULL)"
        }
    }
}
