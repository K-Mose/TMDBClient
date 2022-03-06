package com.kmose.tmdbclient.data.repository.artist

import android.util.Log
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.kmose.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kmose.tmdbclient.domain.repository.ArtistRepository
import com.kmose.tmdbclient.model.artist.Artist

class ArtistRepositoryImpl (
    private val artistRemoteDataSourceData: ArtistRemoteDataSource,
    private val artistLocalDataSourceData: ArtistLocalDataSource,
    private val artistCacheDataSourceData: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSourceData.clearAll()
        artistLocalDataSourceData.saveArtistToDB(newListOfArtist)
        artistCacheDataSourceData.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            var response = artistRemoteDataSourceData.getArtistFromAPI()
            var body = response.body()
            if (body != null) {
                artistList = body.Artists
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.stackTrace.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSourceData.getArtistFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.stackTrace.toString())
        }
        if (artistList.isNotEmpty()) {
            artistList = getArtistFromAPI()
            artistLocalDataSourceData.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSourceData.getArtistFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.stackTrace.toString())
        }
        if (artistList.isNotEmpty()) {
            artistList = getArtistFromDB()
            artistCacheDataSourceData.saveArtistToCache(artistList)
        }
        return artistList
    }
}