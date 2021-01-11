package com.rafaelirineu.aula36.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.aula36.R
import com.rafaelirineu.aula36.call.adapter.CharacterAdapter
import com.rafaelirineu.aula36.model.CharacterModel
import com.rafaelirineu.aula36.repository.CharacterRepository
import com.rafaelirineu.aula36.viewmodel.CharacterViewModel


class CallFragment : Fragment() {

    private lateinit var _viewModel: CharacterViewModel
    private lateinit var _view: View
    private lateinit var _listaAdapter: CharacterAdapter
    private lateinit var recyclerView: RecyclerView

    private var _listCharacters = mutableListOf<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_call2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        recyclerView = _view.findViewById(R.id.recyclerView)

        val manager = LinearLayoutManager(view.context)

        _listCharacters = mutableListOf()
        _listaAdapter = CharacterAdapter(_listCharacters)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _viewModel = ViewModelProvider(
            this, CharacterViewModel.CharacterViewModelFactory(
                CharacterRepository()
            )
        ).get(CharacterViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner) {
            exibirLista(it)
        }
    }

    private fun exibirLista(lista: List<CharacterModel>) {
        lista?.let {
            _listCharacters.addAll(lista)
            _listaAdapter.notifyDataSetChanged()
        }
    }

}