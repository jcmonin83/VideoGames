package com.pp.videogames.dbase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBHelper(context: Context?) : SQLiteOpenHelper(context, DB_Name, null, DB_Version) {
    // private static final -> java
    companion object{
        private const val DB_Version = 1
        private const val DB_Name = "videogames.db"
        public const val DB_Tables = "games"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $DB_Tables (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, genre TEXT NOT NULL, developer TEXT NOT NULL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE $DB_Tables")
        onCreate(p0)
    }
}