package com.carlostena.ejercicioadapterbasico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlostena.ejercicioadapterbasico.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var adapter: TextoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaPokemon = MutableList(50) { Pokemon("Nombre$it", Random.nextInt(200 + it), 200 + it) }
        adapter = TextoAdapter(listaPokemon)


        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
        binding.bLimpiarMuertos.setOnClickListener {
            listaPokemon = listaPokemon.filter { it.vidaActual > 0 }.toMutableList()
            adapter.updateListaPokemon(listaPokemon)
        //binding.recyclerview.adapter?.notifyDataSetChanged()
        }


    }

}