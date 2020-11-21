package com.example.movies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.movies.R
import com.example.movies.data.database.Movie
import com.example.movies.data.database.MovieDatabase
import com.example.movies.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception


class ActionMovies : Fragment() {
    private lateinit var allMovies: LiveData<List<Movie>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_action_movies, container, false)

        val newMovie = Movie(1,
            "Pirates" ,
            "About pirates",
        "2 hours",
            "action",
        "www.pirates.com",
        "2020")
        val movieRepository = MovieRepository(MovieDatabase.getDbInstance(view.context))
        val txtView = view.findViewById<TextView>(R.id.txview)
        var result: String
        CoroutineScope(Dispatchers.IO).launch{
            try {
                movieRepository.addMovie(newMovie)
                allMovies = movieRepository.allMovies
                result = allMovies.value.toString()
            } catch (e: Exception){
                result = e.message.toString()
            }

        }

        


        txtView.setOnClickListener {
            Toast.makeText(activity, "Toast HEREREER", Toast.LENGTH_SHORT).show()
        }
        return  view
    }


}