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
        today = dayComparePreference.getString(KEEP_CONNECTED_PREFS, "").toString()



            val isDay = dateFormat.format(calendar.time)

            if (isDay.compareTo(today) == 1) {
                dayComparePreference.edit()
                    .putString(KEEP_CONNECTED_PREFS, isDay)
                    .apply()
                Toast.makeText(this,"Foi ontem",Toast.LENGTH_LONG).show()

            }










//        btn2.setOnClickListener {
//
//            isTomorrow = dateFormat.format(calendar.time)
//
//            Log.d("Data", isTomorrow.compareTo(today).toString())
//            Log.d("Data", today.compareTo(isTomorrow).toString())
//
//            Toast.makeText(this, today, Toast.LENGTH_LONG).show()
//            Toast.makeText(this, isTomorrow, Toast.LENGTH_LONG).show()
//
//        }


    }

    companion object {
        const val DATE_PREFS = "DATE"
        const val KEEP_CONNECTED_PREFS = "GET_DATE_FIRST_LOGIN"
    }
}

