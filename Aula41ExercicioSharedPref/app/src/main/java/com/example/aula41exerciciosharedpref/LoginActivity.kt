package com.example.aula41exerciciosharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<MaterialButton>(R.id.btn_login_login)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)

        val prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE)

        checkbox.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(KEEP_CONNECTED_PREFS, isChecked).apply()
        }

        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val APP_NAME = "Aula41_Preferences"
        const val KEEP_CONNECTED_PREFS = "KEEP_CONNECTED_PREFS"
    }
}