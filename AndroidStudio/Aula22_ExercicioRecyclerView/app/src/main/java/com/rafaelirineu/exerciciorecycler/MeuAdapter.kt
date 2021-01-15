package com.rafaelirineu.exerciciorecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import layout.Usuario

class MeuAdapter(private val dataSet: List<Usuario>) :
    RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nome: TextView = view.findViewById(R.id.nome)
        private val mensagem: TextView = view.findViewById(R.id.mensagem)
        private val hora: TextView = view.findViewById(R.id.hora)

        fun bind(usuario: Usuario){
            nome.text = usuario.nome
            mensagem.text = usuario.mensagem
            hora.text = usuario.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuAdapter.MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return MeuViewHolder(view)

    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}