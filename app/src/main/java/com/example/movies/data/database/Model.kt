package com.example.movies.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey()
    val movie_id:Int,
    val movie_title: String,
    val movie_description: String,
    val movie_duration: String,
    val movie_type: String,
    val movie_url: String,
    val release_year: String
) {}