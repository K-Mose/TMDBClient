package com.kmose.tmdbclient.presentation.di.artist

import com.kmose.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

// subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    // subcomponent factory - to know AppComponent how to create instacne of AritstComponent sub component.
    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
}