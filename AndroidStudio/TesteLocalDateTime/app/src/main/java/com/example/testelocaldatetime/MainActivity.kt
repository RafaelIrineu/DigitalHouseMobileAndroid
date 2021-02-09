package com.example.testelocaldatetime

import android.annotation.SuppressLint
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

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val calendar: Calendar = Calendar.getInstance()

    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dayComparePreference = getSharedPreferences(DATE_PREFS, MODE_PRIVATE)

        val btn2 = findViewById<Button>(R.id.button2)

        today = dateFormat.format(calendar.time)

        today = dayComparePreference.getString(DATE_PREFS, "").toString()

        if (isTomorrow.compareTo(today) == 1) {
            //dia de hoje é maior que o de ontem
            val validador = true
        } else {
            //dia de hoje é igual ou menor que o de ontem
            val validador = false
        }

        btn2.setOnClickListener {

            isTomorrow = dateFormat.format(calendar.time)

            Log.d("Data", isTomorrow.compareTo(today).toString())
            Log.d("Data", today.compareTo(isTomorrow).toString())

            Toast.makeText(this, today, Toast.LENGTH_LONG).show()
            Toast.makeText(this, isTomorrow, Toast.LENGTH_LONG).show()

        }

        dayComparePreference.edit()
                .putString(DATE_PREFS, today)
                .apply()
    }

    companion object {
        const val DATE_PREFS = "DATE"
        const val KEEP_CONNECTED_PREFS = "GET_DATE_FIRST_LOGIN"
    }
}

