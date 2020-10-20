package com.rafaelirineu.exerciciorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.Usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf(Usuario("Rafael", "Tá devagar aqui", "21:00"),Usuario("Zé", "Tá mesmo", "22:00")))

        recyclerView.apply{
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }
    }
}