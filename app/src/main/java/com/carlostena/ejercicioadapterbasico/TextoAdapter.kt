package com.carlostena.ejercicioadapterbasico

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.carlostena.ejercicioadapterbasico.databinding.ItemPokemonBinding
import kotlin.random.Random

class TextoAdapter(var listaPokemon : MutableList<Pokemon>) : RecyclerView.Adapter<TextoAdapter.TextoViewHolder>() {

    class TextoViewHolder(var itemBinding : ItemPokemonBinding) : RecyclerView.ViewHolder(itemBinding.root)

    fun updateListaPokemon(listaPokemon : MutableList<Pokemon>) {
        this.listaPokemon = listaPokemon
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextoViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextoViewHolder, position: Int) {
        if (listaPokemon[position].vidaActual / listaPokemon[position].vidaMaxima.toFloat() > 0.5)
            holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.purple_200))
        else
            holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.design_default_color_error))

        holder.itemBinding.tvNombre.text = listaPokemon[position].nombre
        holder.itemBinding.tvVida.text = "${listaPokemon[position].vidaActual} / ${listaPokemon[position].vidaMaxima}"
        holder.itemBinding.bQuitarVida.setOnClickListener {
            Toast.makeText(holder.itemBinding.root.context, "Quitando vida al Pokemon ${listaPokemon[position].nombre}", Toast.LENGTH_LONG).show()
            listaPokemon[position].vidaActual -= Random.nextInt(50)
            holder.itemBinding.tvVida.text = "${listaPokemon[position].vidaActual} / ${listaPokemon[position].vidaMaxima}"
            if (listaPokemon[position].vidaActual / listaPokemon[position].vidaMaxima.toFloat() > 0.5)
                holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.purple_200))
            else
                holder.itemBinding.layoutPrincipal.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.design_default_color_error))
        }

        holder.itemBinding.bSumarVida.setOnClickListener {
            Toast.makeText(holder.itemBinding.root.context, "Sumando vida al Pokemon ${listaPokemon[position].nombre}", Toast.LENGTH_LONG).show()
            listaPokemon[position].vidaActual += Random.nextInt(50)
            notifyItemChanged(position)
        }
    }

}