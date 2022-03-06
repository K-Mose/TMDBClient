package com.kmose.tmdbclient.data.repository.movie.datasourceImpl

import com.kmose.tmdbclient.data.api.TMDBService
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.kmose.tmdbclient.model.movie.MovieList
import retrofit2.Response
// Use TMDBService as Dependency
class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}