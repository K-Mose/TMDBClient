package com.kmose.tmdbclient.data
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val Artists: List<Artist>
)