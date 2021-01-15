package com.rafaelirineu.meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btnMostrarNome.setOnClickListener{
        val nome = edtNome.text.toString()

        txtResult.text = getString(R.string.meu_nome, nome)

    }

    }
}