package com.example.movies.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 3, exportSchema = false)
abstract class MovieDatabase:RoomDatabase() {
    abstract val movieDatabaseDao: MovieDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDbInstance(context: Context): MovieDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movie_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}