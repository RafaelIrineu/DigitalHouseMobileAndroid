package com.rafaelirineu.criandotelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            Toast.makeText(this, "Testando o Toast!", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, NovaTela::class.java)
        }
            //intent.putExtra("NAME", "Rafael")

            //startActivity(intent)

        checkVoceDeseja.setOnClickListener { _,isChecked->
            button.isEnable
        }

        }
    }
