package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class BoundingBox(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)