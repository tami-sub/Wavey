package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("response")
    val response: Response
)