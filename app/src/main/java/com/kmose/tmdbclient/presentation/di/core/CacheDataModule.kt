package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.kmose.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.kmose.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.kmose.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.kmose.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.kmose.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providerMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun providerTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun providerArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}