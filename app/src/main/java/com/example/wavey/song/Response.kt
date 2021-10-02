package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("song")
    val song: SongX
)