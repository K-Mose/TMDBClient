package com.kmose.tmdbclient.data.repository.movie.datasource

import com.kmose.tmdbclient.model.movie.MovieList
import retrofit2.Response

/**
 * MovieList를 API를 호춣하여 TMDB에서 데이터를 가져오는 클래스 인터페이스.
 * Local Room에 Data가 없을 때 호출된다.
 */
interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}