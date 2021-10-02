package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Thumb(
    @SerializedName("bounding_box")
    val boundingBox: BoundingBoxXX,
    @SerializedName("url")
    val url: String
)