package com.example.revisao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText

const val LOGIN_FRAGMENT = 0
const val SIGN_UP_FRAGMENT = 1

class MainActivity : AppCompatActivity(), IMudarTab {

    private val tab by lazy { findViewById<TabLayout>(R.id.layoutLogin)}
    //o by lazy espera a view ser criada para atribuir, senão o código quebra

    private lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        tab.setupWithViewPager(pager) //tab use esse viewpager

        loginFragment = LoginFragment()

        pager.adapter = LoginAdapter(
            listOf(loginFragment, SignUpFragment()), //lista de fragmentos
            listOf("Sign In", "Sign Up"), //lista de títulos
            supportFragmentManager //precisa para criar o tablayout
        )
    }

    override fun mudarTab(posicaoAtual: Int){
        var novaPosicao = definePosicao(posicaoAtual)
        val tabNova = tab.getTabAt(novaPosicao)
        tabNova?.select()
    }

    override fun usernameAlterado(username: String) {
        //como queremos manipular o loginFragment aqui, vamos armazenar ele em uma variável
        //então precisamos trocar onde estava LoginFragment() por loginFragment
        loginFragment.usernameAlterado(username)
        //clicar em creat member function
        //para criar essa função lá no LoginFragment
    }

    private fun definePosicao(posicaoAtual: Int) =
        if (posicaoAtual == LOGIN_FRAGMENT) {
        SIGN_UP_FRAGMENT
        } else {
        LOGIN_FRAGMENT
        }
}