package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.data.db.ArtistDao
import com.kmose.tmdbclient.data.db.MovieDao
import com.kmose.tmdbclient.data.db.TvShowDao
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.kmose.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.kmose.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.kmose.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    // construct and return MovieLocalDataSourceImpl
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}