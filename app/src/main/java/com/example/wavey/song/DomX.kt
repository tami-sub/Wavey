package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class DomX(
    @SerializedName("children")
    val children: List<Any>,
    @SerializedName("tag")
    val tag: String
)