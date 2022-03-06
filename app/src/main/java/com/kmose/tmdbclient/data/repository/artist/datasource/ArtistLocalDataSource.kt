package com.kmose.tmdbclient.data.repository.artist.datasource

import com.kmose.tmdbclient.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun clearAll()
}