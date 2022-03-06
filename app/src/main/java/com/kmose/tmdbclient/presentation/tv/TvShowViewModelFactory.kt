package com.kmose.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kmose.tmdbclient.domain.usecase.GetTvShowsUsecase
import com.kmose.tmdbclient.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModelFactory(
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUsecase, updateTvShowsUsecase) as T
    }
}