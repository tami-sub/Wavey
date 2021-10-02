package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("medium")
    val medium: Medium,
    @SerializedName("small")
    val small: Small,
    @SerializedName("thumb")
    val thumb: Thumb,
    @SerializedName("tiny")
    val tiny: Tiny
)