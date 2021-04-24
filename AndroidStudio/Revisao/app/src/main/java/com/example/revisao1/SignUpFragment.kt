package com.example.revisao1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val btnSignUp = view.findViewById<MaterialButton>(R.id.btnSignUp)
        val txtEditUsername = view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp)

        btnSignUp.setOnClickListener {
            if (validaEntradas(view)) {
                mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
                mudarTabListener.usernameAlterado(txtEditUsername.text.toString())
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mudarTabListener = context as IMudarTab
    }

    private fun validaEntradas(view: View): Boolean {
        var resultado = true

        val edtUserNameSignUp = view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp)
        val edtPasswordSignUp = view.findViewById<TextInputEditText>(R.id.edtTextPasswordSignUp)
        val edtRepeatPasswordSignUp = view.findViewById<TextInputEditText>(R.id.edtTextRepeatPasswordSignUp)

        if (edtUserNameSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameSignUp).error = "Usuário vazio"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!!.length < 6) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Mínimo 6 caracteres"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Senha vazia"
            resultado = false
        }

        if (edtRepeatPasswordSignUp.text?.trim()!!.length < 6) {
            view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignUp).error = "Mínimo 6 caracteres"
            resultado = false
        }

        if (edtRepeatPasswordSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignUp).error = "Senha vazia"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!! != edtRepeatPasswordSignUp.text?.trim()!!) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Senhas divergentes"
            view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignUp).error =
                "Senhas divergentes"
            resultado = false
        }

        return resultado
    }

}