package com.example.revisao1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //primeiro de tudo associar a view! não esquecer do return no fim e tirar o return padrão!!
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (validaEntradas(view)) {
                Toast.makeText(view.context, "Login realizado", Toast.LENGTH_LONG).show()
            }
        }

        //abaixo o código para fazer com que após dar o erro de campo vazio, ao começar a digitar
        //o erro seja escondido
        view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = ""
                }
            })

        view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
                }
            })

        return view
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = "Usuário vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = "Senha vazia"
            resultado = false
        }

        return resultado
    }
}