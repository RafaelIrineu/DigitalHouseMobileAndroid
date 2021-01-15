package com.rafaelirineu.calculosalario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{
            val horasTrabalhadas = edtHoras.text.toString().toInt()
            val valorHora = edtValor.text.toString().toInt()
            val salario = horasTrabalhadas * valorHora

            txtResult.text = getString(R.string.resultado, salario)

        }

    }
}