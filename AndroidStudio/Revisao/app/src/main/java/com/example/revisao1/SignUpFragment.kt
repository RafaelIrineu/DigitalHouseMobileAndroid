package com.example.revisao1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton

class SignUpFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val btnSignUp = view.findViewById<MaterialButton>(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mudarTabListener = context as IMudarTab
    }
}