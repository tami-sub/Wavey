package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Interactions(
    @SerializedName("following")
    val following: Boolean,
    @SerializedName("pyong")
    val pyong: Boolean
)