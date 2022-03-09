package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kmose.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.kmose.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.kmose.tmdbclient.domain.repository.ArtistRepository
import com.kmose.tmdbclient.domain.repository.MovieRepository
import com.kmose.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module // provide repository dependency to usecase
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
    @Singleton
    @Provides
    fun provideArtistRepository(
        ArtistRemoteDatasource: ArtistRemoteDataSource,
        ArtistLocalDataSource: ArtistLocalDataSource,
        ArtistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            ArtistRemoteDatasource,
            ArtistLocalDataSource,
            ArtistCacheDataSource
        )
    }
}