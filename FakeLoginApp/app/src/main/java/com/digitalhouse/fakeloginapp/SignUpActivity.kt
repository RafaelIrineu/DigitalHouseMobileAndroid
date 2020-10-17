package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnCreatAccount.setOnClickListener{
            finish()
        }

        checkAgree.setOnCheckedChangeListener{_, isChecked->
            btnCreatSignUp.isEnabled = isChecked
        }

        btnCreatSignUp.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtCreatEmail.text.toString()
            val password = edtCreatPassword.text.toString()

            if(name.isEmpty()){
                edtName.error = "Campo vazio"
            } else {

                try {
                    UserService.register(name, email, password)
                    Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }
            }

        }

    }
}