package com.kmose.tmdbclient.domain.usecase

import com.kmose.tmdbclient.domain.repository.ArtistRepository
import com.kmose.tmdbclient.model.artist.Artist

class UpdateArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}