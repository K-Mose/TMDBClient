package com.kmose.tmdbclient.data.repository.artist.datasourceImpl

import com.kmose.tmdbclient.data.api.TMDBService
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kmose.tmdbclient.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtistFromAPI(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}