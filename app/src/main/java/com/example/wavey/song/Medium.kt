package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("bounding_box")
    val boundingBox: BoundingBox,
    @SerializedName("url")
    val url: String
)