package com.kmose.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kmose.tmdbclient.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>
}