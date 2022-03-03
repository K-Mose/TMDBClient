package com.kmose.tmdbclient.domain.repository

import com.kmose.tmdbclient.model.movie.Movie

// repository interfaces will be implemented in the data layer. And these will usecase will be executed from  the ViewModels of presentation layer.
interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}