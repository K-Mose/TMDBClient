package com.kmose.tmdbclient.presentation.di

import com.kmose.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.kmose.tmdbclient.presentation.di.movie.MovieSubComponent
import com.kmose.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}