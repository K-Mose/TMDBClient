package com.kmose.tmdbclient.domain.usecase

import com.kmose.tmdbclient.domain.repository.MovieRepository
import com.kmose.tmdbclient.model.movie.Movie

class UpdateMoviesUsecase(private val movieRepository: MovieRepository)  {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}