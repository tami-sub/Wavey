package com.example.wavey.artist


import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("results")
    val results: Results
)