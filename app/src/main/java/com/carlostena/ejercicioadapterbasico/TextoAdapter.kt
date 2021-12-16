package com.carlostena.ejercicioadapterbasico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
        if (position %2 == 0) {
            holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.design_snackbar_background_color))
            holder.itemBinding.textView.text = "La pos $position es par"
        } else {
            holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.design_default_color_error))
            holder.itemBinding.textView.text = "La pos $position es impar"
        }
    }

}