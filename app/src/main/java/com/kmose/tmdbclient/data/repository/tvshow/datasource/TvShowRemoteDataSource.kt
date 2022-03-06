package com.kmose.tmdbclient.data.repository.tvshow.datasource

import com.kmose.tmdbclient.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowsFromAPI(): Response<TvShowList>
}