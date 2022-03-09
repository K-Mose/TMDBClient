package com.kmose.tmdbclient.presentation.di.movie

import com.kmose.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

// subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    // subcomponent factory - to know AppComponent how to create instacne of AritstComponent sub component.
    @Subcomponent.Factory // Factory to BUilder https://github.com/google/dagger/issues/2997
    interface Factory{

        fun create(): MovieSubComponent
    }
}