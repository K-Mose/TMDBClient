package com.kmose.tmdbclient.data.repository.artist

import com.kmose.tmdbclient.data.db.ArtistDao
import com.kmose.tmdbclient.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl (private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}