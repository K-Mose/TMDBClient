package com.kmose.tmdbclient.domain.usecase

import com.kmose.tmdbclient.domain.repository.ArtistRepository
import com.kmose.tmdbclient.model.artist.Artist

class GetArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}