package com.rafaelirineu.exercicioaula28.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rafaelirineu.exercicioaula28.R
import com.rafaelirineu.exercicioaula28.viewmodel.TarefaViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}