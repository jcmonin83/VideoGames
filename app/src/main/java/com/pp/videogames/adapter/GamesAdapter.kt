package com.pp.videogames.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pp.videogames.databinding.ListItemBinding
import com.pp.videogames.model.Game
import java.util.ArrayList

class GamesAdapter(contexto: Context, lstGames: ArrayList<Game>): BaseAdapter() {
    private  val lstGames = lstGames
    private val layoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return lstGames.size
    }

    override fun getItem(p0: Int): Any {
        return lstGames[p0]
    }

    override fun getItemId(p0: Int): Long {
        return  lstGames[p0].Id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ListItemBinding.inflate(layoutInflater)

        with(binding){
            tvTitle.text = lstGames[p0].Title
            tvGenre.text = lstGames[p0].Genre
            tvDeveloper.text = lstGames[p0].Developer
        }

        return  binding.root
    }
}