package com.kmose.tmdbclient.data.repository.artist.datasourceImpl

import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.kmose.tmdbclient.model.artist.Artist

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}