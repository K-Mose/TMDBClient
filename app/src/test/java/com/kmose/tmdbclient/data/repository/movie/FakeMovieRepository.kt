package com.kmose.tmdbclient.data.repository.movie

import com.kmose.tmdbclient.domain.repository.MovieRepository
import com.kmose.tmdbclient.model.movie.Movie

class FakeMovieRepository : MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.addAll(listOf(
            Movie(1, "overView1", "posterPath1", "date1", "title1"),
            Movie(2, "overView2", "posterPath2", "date2", "title2"),
            Movie(3, "overView3", "posterPath3", "date3", "title3"),
        ))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.addAll(listOf(
            Movie(4, "overView4", "posterPath4", "date4", "title4"),
            Movie(5, "overView5", "posterPath5", "date5", "title5"),
            Movie(6, "overView6", "posterPath6", "date6", "title6"),
        ))
        return movies
    }
}