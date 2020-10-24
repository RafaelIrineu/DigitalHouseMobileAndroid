package com.rafaelirineu.aula24

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fragments: List<Fragment>,
                       private val titulos: List<String>,
                       manager: FragmentManager) : FragmentPagerAdapter(
    manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    //quantos de tabs
    override fun getCount() = fragments.size

    //qual item vai ser exibido, retorna o fragment correspondente a posição
    override fun getItem(position: Int) = fragments[position]

    //se quiser que apareça só os icones é só tirar o getPageTitle
    //clica com o botão direito e em generate, retorna o nome da tab
    override fun getPageTitle(position: Int) = titulos[position]
}