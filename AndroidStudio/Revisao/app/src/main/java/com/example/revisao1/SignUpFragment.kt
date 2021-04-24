package com.example.revisao1

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_up.*

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

        view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtUserNameSignUp).error = ""
                }
            })

        view.findViewById<TextInputEditText>(R.id.edtTextPasswordSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtTextPasswordSignUp).error = ""
                }
            })

        view.findViewById<TextInputEditText>(R.id.edtTextRepeatPasswordSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtTextRepeatPasswordSignUp).error = ""
                }
            })

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
        val checkbox = view.findViewById<CheckBox>(R.id.checkboxSignUp)

        if (edtUserNameSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameSignUp).error = "Usuário vazio"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!!.length < 8) {
            view.findViewById<TextInputLayout>(R.id.txtTextPasswordSignUp).error = "Mínimo 6 caracteres"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtTextPasswordSignUp).error = "Senha vazia"
            resultado = false
        }

        if (edtRepeatPasswordSignUp.text?.trim()!!.length < 8) {
            view.findViewById<TextInputLayout>(R.id.txtTextRepeatPasswordSignUp).error = "Mínimo 6 caracteres"
            resultado = false
        }

        if (edtRepeatPasswordSignUp.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtTextRepeatPasswordSignUp).error = "Senha vazia"
            resultado = false
        }

        if (edtPasswordSignUp.text?.trim()!! != edtRepeatPasswordSignUp.text?.trim()!!) {
            view.findViewById<TextInputLayout>(R.id.txtTextPasswordSignUp).error = "Senhas divergentes"
            view.findViewById<TextInputLayout>(R.id.txtTextRepeatPasswordSignUp).error = "Senhas divergentes"
            resultado = false
        }

        if(!checkbox.isChecked){
            checkbox.error = "Precisa concordar com os termos"
            resultado = false
        }

        return resultado
    }

}