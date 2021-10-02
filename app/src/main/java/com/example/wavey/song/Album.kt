package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("cover_art_url")
    val coverArtUrl: String,
    @SerializedName("full_title")
    val fullTitle: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)