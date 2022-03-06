package com.kmose.tmdbclient.data.repository.tvshow.datasource

import com.kmose.tmdbclient.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}