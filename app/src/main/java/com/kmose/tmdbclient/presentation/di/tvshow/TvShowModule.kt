package com.kmose.tmdbclient.presentation.di.tvshow

import com.kmose.tmdbclient.domain.usecase.GetTvShowsUsecase
import com.kmose.tmdbclient.domain.usecase.UpdateTvShowsUsecase
import com.kmose.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.kmose.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providerArtistViewModelFactory(
        getTvShowUsecase: GetTvShowsUsecase,
        updateTvShowUsecase: UpdateTvShowsUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUsecase,
            updateTvShowUsecase
        )
    }
}