package com.example.wavey.artist


import com.google.gson.annotations.SerializedName

data class Artistmatches(
    @SerializedName("artist")
    val artist: List<Artist>
)