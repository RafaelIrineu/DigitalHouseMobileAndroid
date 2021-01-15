package com.example.aula39exercicioroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula39exercicioroom.listatodo.view.ListaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, ListaFragment())
            .commit()
    }
}