package com.rafaelirineu.testfragmentfuncao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        btnAdicionaFragmentA.setOnClickListener {
            val transaction = manager.beginTransaction()
            addFragment(MeuFragment)
        }

        btnAdicionaFragmentB.setOnClickListener {
            val transaction = manager.beginTransaction()
            addFragment(MeuNovoFragment)
        }
    }

    //addFragment(meuFragment)

    fun addFragment(fragment: Fragment) {
        transaction.add(R.id.fragmentContainer, fragment)
        transaction.commit()

    }
}