package com.kmose.tmdbclient.data.repository.tvshow.datasourceImpl

import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.kmose.tmdbclient.model.tvshow.TvShow

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}