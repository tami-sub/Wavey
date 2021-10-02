package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Dom(
    @SerializedName("children")
    val children: List<Any>,
    @SerializedName("tag")
    val tag: String
)