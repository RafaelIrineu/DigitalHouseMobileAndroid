package com.example.aula41exerciciosharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.aula41exerciciosharedpref.LoginActivity.Companion.KEEP_CONNECTED_PREFS

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val prefs = getSharedPreferences(LoginActivity.APP_NAME, MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(KEEP_CONNECTED_PREFS, false)

        Handler(Looper.getMainLooper()).postDelayed({

            if (prefsChecked) {
                val intentHome = Intent(this, MainActivity::class.java)
                startActivity(intentHome)
                finish()
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}