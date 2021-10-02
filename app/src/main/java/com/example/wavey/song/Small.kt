package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Small(
    @SerializedName("bounding_box")
    val boundingBox: BoundingBoxX,
    @SerializedName("url")
    val url: String
)