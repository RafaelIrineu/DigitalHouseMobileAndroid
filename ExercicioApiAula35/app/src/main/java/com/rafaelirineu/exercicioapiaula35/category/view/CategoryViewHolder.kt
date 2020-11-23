package com.rafaelirineu.exercicioapiaula35.category.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.exercicioapiaula35.R

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val _cardCategory = view.findViewById<TextView>(R.id.txtCategory)

    fun bind(category: String){
        _cardCategory.text = category.capitalize()
    }
}