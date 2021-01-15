package com.rafaelirineu.aula36.call.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.aula36.R
import com.rafaelirineu.aula36.model.CharacterModel
import com.squareup.picasso.Picasso

class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private var ivCharacter: ImageView = itemView.findViewById<ImageView>(R.id.imgCall)
    private var tvName: TextView = itemView.findViewById<TextView>(R.id.txtCallMessage)
    private var tvMessage: TextView = itemView.findViewById<TextView>(R.id.txtCallMessage)


    fun bind(character: CharacterModel){

        tvName.text = character.name
        tvMessage.text = character.nickname

        Picasso.get()
            .load(character.img)
            .into(ivCharacter)

    }
}
