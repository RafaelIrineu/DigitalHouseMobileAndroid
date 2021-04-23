package com.example.revisao1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class LoginAdapter(private val frags: List<Fragment>,
    //lista de fragments
                   private val titles: List<String>,
    //lista de títulos
                   manager: FragmentManager): FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount() = frags.size
    //retorna tamanho da lista de fragments, ou seja, qtd de tabs
    override fun getItem(position: Int) = frags[position]
    //diz qual fragment será jogado na posição
    override fun getPageTitle(position: Int) = titles[position]
    //diz qual título será jogado na posição
}