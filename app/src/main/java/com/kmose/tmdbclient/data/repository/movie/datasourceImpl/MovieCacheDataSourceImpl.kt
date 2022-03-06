package com.kmose.tmdbclient.data.repository.movie.datasourceImpl

import com.kmose.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.kmose.tmdbclient.model.movie.Movie

// singleton으로 사용해 유지시킴
class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromCache(): List<Movie> {
        // create an ArrayList of Movie instances,
        // Then,whenever the user launches the app and load movie data for the first time we will assign that to this arrayList
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}