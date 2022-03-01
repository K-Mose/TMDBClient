package com.kmose.tmdbclient.model.artist
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artist") // set different room database table name from json object
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @ColumnInfo()
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)