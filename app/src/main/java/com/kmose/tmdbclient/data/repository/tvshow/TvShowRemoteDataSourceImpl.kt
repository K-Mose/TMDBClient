package com.kmose.tmdbclient.data.repository.tvshow

import com.kmose.tmdbclient.data.api.TMDBService
import com.kmose.tmdbclient.model.tvshow.TvShow
import com.kmose.tmdbclient.model.tvshow.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl (
    private val tmdbServie: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShowsFromAPI(): Response<TvShowList> = tmdbServie.getPopularTvShows(apiKey)
}