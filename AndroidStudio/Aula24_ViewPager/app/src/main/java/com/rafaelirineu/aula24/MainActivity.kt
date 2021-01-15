package com.rafaelirineu.aula24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.view_pager)
        val tab = findViewById<TabLayout>(R.id.tab_layout)

        // faz com que o tab use o viewpager
        tab.setupWithViewPager(pager)

        //cria a lista com os fragments
        //val fragments = listOf(MeuFragment(), MeuFragment(), MeuFragment())
        val fragments = listOf(
            MeuFragment.newInstance("Felipe", true),
            MeuFragment.newInstance("Paulo", false),
            MeuFragment.newInstance("Renan", true))

        //cria a lista com os nomes das tabs
        val titulos = listOf(getString(R.string.home), getString(R.string.biblioteca),
            getString(R.string.favoritos))

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)

        //adiciona ícones nas tabs
        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_library_books_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_favorite_24)

        //adiciona badge na tab
        tab.getTabAt(0)!!.orCreateBadge.apply{
            number = 100
            maxCharacterCount = 2
            isVisible = true
        }

        tab.getTabAt(1)!!.orCreateBadge.apply{
            number = 5
            maxCharacterCount = 2
            isVisible = true
        }

        tab.getTabAt(2)!!.orCreateBadge.apply{
            number = 30
            maxCharacterCount = 3
            isVisible = true
        }

        tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(selected: TabLayout.Tab?) {
                if (selected!!.position == 0) {
                tab.getTabAt(0)!!.badge?.isVisible = false
            }
            }

        })

    }
}