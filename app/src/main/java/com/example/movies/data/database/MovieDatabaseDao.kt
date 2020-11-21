package com.example.movies.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM movie_table ORDER BY movie_id DESC")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table ORDER BY movie_id DESC LIMIT 5")
    fun getLatestMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE movie_type = 'action' ")
    fun getActionMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE movie_type = 'adventure' ")
    fun getAdventureMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE movie_type = 'drama' ")
    fun getDramaMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE movie_type = 'epic' ")
    fun getEpicMovies(): LiveData<List<Movie>>
}