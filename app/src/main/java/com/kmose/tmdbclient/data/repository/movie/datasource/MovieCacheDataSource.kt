package com.kmose.tmdbclient.data.repository.movie.datasource

import com.kmose.tmdbclient.model.movie.Movie

/**
 * MovieList를 singleton instance에 저장, 불러오는 클래스 인터페이스
 * getMovieFromCache()로 데이터 호출, saveMovieToCache()로 인스턴스에 더이터 저장
 */
interface MovieCacheDataSource {
    suspend fun getMovieFromCache(): List<Movie>
    suspend fun saveMovieToCache(movies: List<Movie>)
}