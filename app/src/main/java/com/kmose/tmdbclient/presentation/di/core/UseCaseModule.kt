package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.domain.repository.ArtistRepository
import com.kmose.tmdbclient.domain.repository.MovieRepository
import com.kmose.tmdbclient.domain.repository.TvShowRepository
import com.kmose.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUsecase {
        return GetTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUsecase {
        return UpdateTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUsecase {
        return GetArtistsUsecase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUsecase {
        return UpdateArtistsUsecase(artistRepository)
    }


}