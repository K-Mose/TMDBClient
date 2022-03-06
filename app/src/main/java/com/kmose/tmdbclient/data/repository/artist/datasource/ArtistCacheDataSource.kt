package com.kmose.tmdbclient.data.repository.artist.datasource

import com.kmose.tmdbclient.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}