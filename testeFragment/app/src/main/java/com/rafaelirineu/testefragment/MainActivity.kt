package com.rafaelirineu.testefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            transaction.add(R.id.fragmentContainer, MeuFragment())
            transaction.commit()
        }

        btnAdicionaFragmentB.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.add(R.id.fragmentContainer, MeuOutroFragment())
            transaction.commit()
        }
    }

    //addFragment(meuFragment)

    /*fun addFragment(fragment: Fragment){
    * transaction.replace(R.id.fragmenteContainer, fragment)
    * transaction.commit()*/

}