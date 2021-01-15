package com.rafaelirineu.testerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dataSet: List<String>) :
    RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val meuTexto: TextView = view.findViewById(R.id.meuTexto)

        fun bind(string: String){
            meuTexto.text = string
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