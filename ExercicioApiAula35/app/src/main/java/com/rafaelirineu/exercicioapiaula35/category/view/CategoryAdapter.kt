package com.rafaelirineu.exercicioapiaula35.category.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.exercicioapiaula35.R

class CategoryAdapter(private val _category: MutableList<String>,
                      private val _listener:(String) ->Unit):
    RecyclerView.Adapter<CategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.category_card,
            parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount() = _category.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = _category[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {_listener(item) }
    }
}