package com.kmose.tmdbclient.data.repository.tvshow.datasource

import com.kmose.tmdbclient.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearALl()
}