package com.kmose.tmdbclient.data.repository.movie

import android.util.Log
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.kmose.tmdbclient.domain.repository.MovieRepository
import com.kmose.tmdbclient.model.movie.Movie

/**
 *
 *
 */
class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        // cache에서 데이터 리턴, 없으면 DB에서 데이터 리턴, 없으면 API에서 데이터 리턴
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        // API로 새로운 데이터 호출
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll() // 로컬 데이터 제거
        movieLocalDataSource.saveMovieToDB(newListOfMovies) // 로컬에 새로운 데이터 저장
        movieCacheDataSource.saveMovieToCache(newListOfMovies) // 새롭게 저장된 데이터 캐시에 저장
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if(movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMovieFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if(movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList
    }
}