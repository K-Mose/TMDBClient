package com.kmose.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kmose.tmdbclient.domain.usecase.GetArtistsUsecase
import com.kmose.tmdbclient.domain.usecase.UpdateArtistsUsecase

class ArtistViewModelFactory(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUsecase, updateArtistsUsecase) as T
    }
}