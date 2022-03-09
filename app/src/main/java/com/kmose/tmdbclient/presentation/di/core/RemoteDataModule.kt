package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.data.api.TMDBService
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kmose.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.kmose.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.kmose.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey: String
) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}