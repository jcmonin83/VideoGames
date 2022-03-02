package com.pp.videogames.dbase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.pp.videogames.model.Game
import java.lang.Exception

class DBGames(context: Context?) : DBHelper(context) {
    // Codigo para CRUD
    val context = context

    fun getGames():ArrayList<Game>{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        var lstGame = ArrayList<Game>()
        var gameTmp: Game? = null
        var cursorGames: Cursor? = null

        cursorGames = db.rawQuery("select * from $DB_Tables", null)

        if(cursorGames.moveToFirst()){
            do{
                gameTmp = Game(cursorGames.getInt(0),cursorGames.getString(1),cursorGames.getString(2),cursorGames.getString(3))
                lstGame.add(gameTmp)
            }while(cursorGames.moveToNext())
        }
        return  lstGame
    }

    fun insertGame(game: Game): Long{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var id: Long = 0

        try {
            val values = ContentValues()
            values.put("title", game.Title)
            values.put("genre", game.Genre)
            values.put("developer", game.Developer)

            id = db.insert(DB_Tables, null,values)

        }catch (e: Exception){
            id = -1
        }finally {
            db.close()
        }

        return id
    }
}