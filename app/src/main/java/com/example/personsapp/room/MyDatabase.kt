package com.example.personsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.personsapp.entity.Persons


/*@Database(entities = [Persons::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun personsDao() : PersonDao

    companion object{
        var INSTANCE : MyDatabase? = null

        fun accessDatabase(context: Context):MyDatabase?{
            if (INSTANCE == null){
                synchronized(MyDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase :: class.java,
                        "rehber.sqlite"
                    ).createFromAsset("rehber.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}*/