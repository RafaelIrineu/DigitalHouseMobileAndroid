package com.example.revisao1

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class LoginFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //primeiro de tudo associar a view! não esquecer do return no fim e tirar o return padrão!!
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)
        val btnSignUpLogin = view.findViewById<Button>(R.id.btnSignUpLogin)

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

        btnSignUpLogin.setOnClickListener{
            mudarTabListener.mudarTab()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //fazer uma interface para comunicar do fragment para a activity
        //vamos fazer com que ao clicar no signup ele troque de fragment
        //quem manipula a tab é a activity, não podemos delegar isso para o fragment
        //pois fere o princípio do SOLID, temos que delegar para quem é realmente
        //o dono da informação

        //criar a interface, colocar a interface na main activity, assim:
        // class MainActivity : AppCompatActivity(), IMudarTab
        // colocar a função mudarTab como override na main
        //aqui no loginfragment precisa dar um cast

        mudarTabListener = context as IMudarTab //aqui o cast, isso quer dizer que esse contexto agora é o IMudarTab
        //mas precisa armazenar isso uma variável, lá em cima
        //assim: private lateinit var mudarTabListener: IMudarTab
        //como vai inicializar a variável depois, colocar lateinit
        //agora precisamos ouvir o botão

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