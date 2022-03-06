package com.kmose.tmdbclient.data.repository.artist.datasource

import com.kmose.tmdbclient.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistFromAPI(): Response<ArtistList>
}