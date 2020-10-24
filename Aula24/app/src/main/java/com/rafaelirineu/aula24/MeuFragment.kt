package com.rafaelirineu.aula24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString("TEXTO")
            param2 = it.getBoolean("É MAIOR DE IDADE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_meu, container, false)

        minhaView.findViewById<TextView>(R.id.txtMeuTexto).text = param1

        return minhaView
    }

    companion object {
        @JvmStatic
        fun newInstance(texto: String, eMaiorDeIdade: Boolean) =
            MeuFragment().apply {
                arguments = Bundle().apply {
                    putString("TEXTO", texto)
                    putBoolean("É MAIOR DE IDADE", eMaiorDeIdade)
                }
            }
    }
}