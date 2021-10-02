package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Tiny(
    @SerializedName("bounding_box")
    val boundingBox: BoundingBoxXXX,
    @SerializedName("url")
    val url: String
)