package com.kmose.tmdbclient.domain.repository

import com.kmose.tmdbclient.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}