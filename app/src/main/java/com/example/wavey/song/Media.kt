package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("attribution")
    val attribution: String,
    @SerializedName("native_uri")
    val nativeUri: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)