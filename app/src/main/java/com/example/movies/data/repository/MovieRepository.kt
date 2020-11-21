package com.example.movies.data.repository

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.example.movies.data.database.Movie
import com.example.movies.data.database.MovieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val database: MovieDatabase) {
    /**
     * Get all movies, and movies in different categories
     * */
    val allMovies: LiveData<List<Movie>> = database.movieDatabaseDao.getAllMovies()
    val actionMovies = database.movieDatabaseDao.getActionMovies()
    val adventureMovies = database.movieDatabaseDao.getAdventureMovies()
    val epicMovies = database.movieDatabaseDao.getEpicMovies()
    val dramaMovies = database.movieDatabaseDao.getDramaMovies()
    val latestMovies = database.movieDatabaseDao.getLatestMovies()

    /**
     * Store movies
     * */
    suspend fun addMovie(movie: Movie){
        withContext(Dispatchers.IO){
            database.movieDatabaseDao.insert(movie)
        }
    }
}