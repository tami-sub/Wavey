package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class CustomPerformance(
    @SerializedName("artists")
    val artists: List<ArtistX>,
    @SerializedName("label")
    val label: String
)