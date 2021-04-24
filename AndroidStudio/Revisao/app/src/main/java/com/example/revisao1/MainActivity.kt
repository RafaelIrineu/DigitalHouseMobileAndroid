package com.example.revisao1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), IMudarTab {
    private val tab by lazy { findViewById<TabLayout>(R.id.layoutLogin)}
    //o by lazy espera a view ser criada para atribuir, senão o código quebra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        tab.setupWithViewPager(pager) //tab use esse viewpager

        pager.adapter = LoginAdapter(
            listOf(LoginFragment(), SignUpFragment()), //lista de fragmentos
            listOf("Sign In", "Sign Up"), //lista de títulos
            supportFragmentManager //precisa para criar o tablayout
        )
    }

    override fun mudarTab(){
        val tabNova = tab.getTabAt(1)
        tabNova?.select()
    }
}