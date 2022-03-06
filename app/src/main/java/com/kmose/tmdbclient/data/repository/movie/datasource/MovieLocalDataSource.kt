package com.kmose.tmdbclient.data.repository.movie.datasource

import com.kmose.tmdbclient.model.movie.Movie

/**
 * MovieList를 local room data에 저장하는 클래스,
 * Cache data가 없을 때 호출된다.
 */
interface MovieLocalDataSource {
    suspend fun getMovieFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearAll()
}