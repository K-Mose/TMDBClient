package com.kmose.tmdbclient.domain.usecase

import com.kmose.tmdbclient.domain.repository.TvShowRepository
import com.kmose.tmdbclient.model.tvshow.TvShow

class GetTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}