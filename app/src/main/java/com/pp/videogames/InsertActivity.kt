package com.pp.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pp.videogames.databinding.ActivityInsertBinding
import com.pp.videogames.dbase.DBGames
import com.pp.videogames.model.Game

class InsertActivity : AppCompatActivity() {

    private  lateinit var insertBinding: ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
    }

    fun click(view: View) {
        val dbGames = DBGames(this)
        with(insertBinding){
            if(!tieTitulo.text.toString().isNullOrEmpty() && !tieGenero.text.toString().isNullOrEmpty() && !tieDesarrollador.text.toString().isNullOrEmpty() ){
                val id = dbGames.insertGame(Game(0,tieTitulo.text.toString(),tieGenero.text.toString(),tieDesarrollador.text.toString() ))
                if(id > 0){
                    Toast.makeText(this@InsertActivity,"Registro agregado",Toast.LENGTH_SHORT).show()
                    tieTitulo.setText("")
                    tieGenero.setText("")
                    tieDesarrollador.setText("")
                }else{
                    Toast.makeText(this@InsertActivity,"Error al agregar el registro",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@InsertActivity,MainActivity::class.java))
        finish()
    }
}