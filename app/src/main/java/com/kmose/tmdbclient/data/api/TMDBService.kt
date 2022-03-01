package com.kmose.tmdbclient.data.api

import com.kmose.tmdbclient.model.artist.ArtistList
import com.kmose.tmdbclient.model.movie.MovieList
import com.kmose.tmdbclient.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    // MovieList class 형태로 JSON 데이터가 들어옴
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey:String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query("api_key") apiKey:String
    ): Response<ArtistList>
}