package com.example.aula41sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch = findViewById<Switch>(R.id.switch1)

        val prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(NOTIFICATION_PREFS,false)
        //o false diz que o valor padrao e falso, porque quando o usuario roda a app pela primeira
        //vez, nao existe nenhum valor

        switch.isChecked = prefsChecked

        //e agora salva a preferencia na val prefschecked

        //escreve o valor
        //quando nao queremos usar algum valor, usamos o underline _
        switch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(NOTIFICATION_PREFS,isChecked).apply()
        }
    }

    companion object {
        const val APP_NAME = "Aula41_Preferences"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }
}