package com.kmose.tmdbclient.presentation.di.artist

import com.kmose.tmdbclient.domain.usecase.GetArtistsUsecase
import com.kmose.tmdbclient.domain.usecase.UpdateArtistsUsecase
import com.kmose.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providerArtistViewModelFactory(
        getArtistsUsecase: GetArtistsUsecase,
        updateArtistsUsecase: UpdateArtistsUsecase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUsecase,
            updateArtistsUsecase
        )
    }
}