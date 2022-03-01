package com.kmose.tmdbclient.model.artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val Artists: List<Artist>
)