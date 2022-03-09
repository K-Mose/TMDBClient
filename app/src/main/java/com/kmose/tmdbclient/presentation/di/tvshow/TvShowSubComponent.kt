package com.kmose.tmdbclient.presentation.di.tvshow

import com.kmose.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

// subcomponent
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(artistActivity: ArtistActivity)

    // subcomponent factory - to know AppComponent how to create instacne of AritstComponent sub component.
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}