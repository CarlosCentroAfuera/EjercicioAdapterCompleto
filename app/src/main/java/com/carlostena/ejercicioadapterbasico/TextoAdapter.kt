package com.carlostena.ejercicioadapterbasico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlostena.ejercicioadapterbasico.databinding.ItemTextoBinding

class TextoAdapter : RecyclerView.Adapter<TextoAdapter.TextoViewHolder>() {

    class TextoViewHolder(var itemBinding : ItemTextoBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun getItemCount(): Int {
        return 50
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextoViewHolder {
        val binding = ItemTextoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextoViewHolder, position: Int) {
        holder.itemBinding.textView.text = "Estoy en la pos $position"
    }

}