package com.rafaelirineu.revisandoaula22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.revisandoaula22.R.id.minhaLista
import layout.MeuAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this,2)
        val recyclerView = findViewById<RecyclerView>(minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf("Laranja", "Cenoura", "Cambuci", "Jaca"))

        recyclerView.apply{
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}