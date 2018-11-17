package com.example.estudiante.db

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sqlTest = DataBaseOpenHelper(this)

        sqlTest.saveUser("Roberto Carlos")
        sqlTest.saveUser("Gabriela")
        sqlTest.saveUser("Stephanie Fernanda")
        sqlTest.saveUser("Nicole Melanie")

        sqlTest.getUsers().forEach {
            Log.d("DB", it )
        }
        sqlTest.close()

    }
}
