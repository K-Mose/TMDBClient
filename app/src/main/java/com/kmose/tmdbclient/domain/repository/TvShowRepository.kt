package com.kmose.tmdbclient.domain.repository

import com.kmose.tmdbclient.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}