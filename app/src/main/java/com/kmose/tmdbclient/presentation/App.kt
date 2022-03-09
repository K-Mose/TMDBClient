package com.kmose.tmdbclient.presentation

import android.app.Application
import com.kmose.tmdbclient.BuildConfig
import com.kmose.tmdbclient.presentation.di.Injector
import com.kmose.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.kmose.tmdbclient.presentation.di.core.*
import com.kmose.tmdbclient.presentation.di.movie.MovieSubComponent
import com.kmose.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(),Injector {
    private lateinit var appComponent: AppComponent

    // appComponent
    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.builder()
             .appModule(AppModule(applicationContext))
             .netModule(NetModule(BuildConfig.BASE_URL))
             .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
             .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.moviesSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}