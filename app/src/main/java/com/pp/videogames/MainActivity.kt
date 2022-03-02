package com.pp.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pp.videogames.adapter.GamesAdapter
import com.pp.videogames.databinding.ActivityMainBinding
import com.pp.videogames.dbase.DBGames
import com.pp.videogames.dbase.DBHelper
import com.pp.videogames.model.Game

class MainActivity : AppCompatActivity() {
    private lateinit var lstGames: ArrayList<Game>
    private  lateinit var vBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        //probando la generacion de la DB
//        val dbHelper = DBHelper(this)
//        val db = dbHelper.writableDatabase
//
//        if (db != null){
//            Toast.makeText(this, "Base de datos fue creada exitosamente", Toast.LENGTH_SHORT).show()
//        }else {Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show()}

        val dbGames = DBGames(this)
        lstGames =dbGames.getGames()
        val gamesAdapter = GamesAdapter(this, lstGames)
        vBinding.lvVideoGame.adapter = gamesAdapter

        //vBinding.lvVideoGame.setOnClickListener { ada}
    }

    fun click(view: View) {
        //Click del boton flotante
        startActivity(Intent(this,InsertActivity::class.java))
        finish()
    }
}