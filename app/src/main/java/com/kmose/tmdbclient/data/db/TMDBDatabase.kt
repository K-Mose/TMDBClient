package com.kmose.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kmose.tmdbclient.model.artist.Artist
import com.kmose.tmdbclient.model.movie.Movie
import com.kmose.tmdbclient.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}