package com.example.aula39.cartao.entity.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.aula39.R
import com.example.aula39.cartao.entity.CartaoEntity
import com.example.aula39.cartao.entity.repository.CartaoRepository
import com.example.aula39.cartao.entity.viewmodel.CartaoViewModel
import com.example.aula39.db.AppDatabase

class CartaoFragment : Fragment() {
    lateinit var _viewModel: CartaoViewModel
    lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _viewModel = ViewModelProvider(
            this,
            CartaoViewModel.CartaoViewModelFactory(
                CartaoRepository(
                    AppDatabase.getDatabase(view.context).cartaoDao()
                )
            )
        ).get(CartaoViewModel::class.java)

        cadastrarCartao(CartaoEntity(0, "123321", "Rafael", "321", "10/21", "Master"))
    }

    fun cadastrarCartao(cartaoEntity: CartaoEntity) {
        _viewModel.addCartao(
            CartaoEntity(0, "123321", "Rafael", "321", "10/21", "Master")
        ).observe(viewLifecycleOwner, {
            Log.i("PAGBEM", it.toString())

            _viewModel.count().observe(viewLifecycleOwner, {
                _view.findViewById<TextView>(R.id.txtQuantidade).text = it.toString()
            })
        })
    }
}