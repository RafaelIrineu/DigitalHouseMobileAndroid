package com.example.aula39exercicioroom.listatodo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39exercicioroom.R
import com.example.aula39exercicioroom.db.AppDatabase
import com.example.aula39exercicioroom.listatodo.entity.ListaEntity
import com.example.aula39exercicioroom.listatodo.repository.ListaRepository
import com.example.aula39exercicioroom.listatodo.viewmodel.ListaViewModel
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment() {
    private lateinit var _viewModel: ListaViewModel
    private lateinit var _view: View
    private lateinit var _adapter: ListaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _viewModel = ViewModelProvider(
            this, ListaViewModel.ListaViewModelFactory(
                ListaRepository(AppDatabase.getDatabase(_view.context).listaDao())
            )
        ).get(ListaViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val manager = LinearLayoutManager(view.context)

        _adapter = ListaAdapter()

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _adapter
        }

        bindEvents()
        initialize()
    }

    private fun initialize() {
        _viewModel.obterTarefas().observe(viewLifecycleOwner, {
            _adapter.adicionarTarefas(it)
        })
    }

    private fun bindEvents() {
        _view.findViewById<Button>(R.id.btnInserir).setOnClickListener {
            val editarTarefa = _view.findViewById<EditText>(R.id.txtTarefa)
            val descricao = editarTarefa.text.toString()
            editarTarefa.setText("")
            val parametros = descricao.split(",")

            if (parametros.size > 1) {
                _viewModel.atualizarTarefa(parametros[0].toLong(), parametros[1]).observe(viewLifecycleOwner, {
                    _adapter.atualizar(ListaEntity(parametros[0].toLong(), parametros[1]))
                        })
            } else {
                _viewModel.inserirTarefa(descricao).observe(viewLifecycleOwner, {
                    _adapter.adicionarTarefa(it)
                })
            }
        }
    }
}