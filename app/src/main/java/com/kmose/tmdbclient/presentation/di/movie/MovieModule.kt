package com.kmose.tmdbclient.presentation.di.movie

import com.kmose.tmdbclient.domain.usecase.GetMoviesUseCase
import com.kmose.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.kmose.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providerArtistViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}