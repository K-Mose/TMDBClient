package com.kmose.tmdbclient.presentation.di.core

import com.kmose.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.kmose.tmdbclient.presentation.di.movie.MovieSubComponent
import com.kmose.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

// Component Interface
@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun moviesSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}