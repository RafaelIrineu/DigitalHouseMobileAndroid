package com.example.testelocaldatetime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var isTomorrow: String
    lateinit var today: String

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val calendar = Calendar.getInstance()

    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val btn2 = findViewById<Button>(R.id.button2)

        today = dateFormat.format(calendar.time)

        if (isTomorrow.compareTo(today) == 1) {
            //dia de hoje é maior que o de ontem
            val validador = true
        } else {
            //dia de hoje é igual ou menor que o de ontem
            val validador = false
        }

        btn2.setOnClickListener {

            isTomorrow = "2021-02-10"

            Log.d("Data", isTomorrow.compareTo(today).toString())
            Log.d("Data", today.compareTo(isTomorrow).toString())

            Toast.makeText(this, today, Toast.LENGTH_LONG).show()
            Toast.makeText(this, isTomorrow, Toast.LENGTH_LONG).show()

        }

        val keepConnectedPreference = getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)
        keepConnectedPreference.edit()
                .putString(DATA_PREFS, today)
                .apply()
    }

    companion object {
        const val DATA_PREFS = "DATA"
        const val KEEP_CONNECTED_PREFS = "SAVE_LOGIN_PREFERENCES"
    }
}

