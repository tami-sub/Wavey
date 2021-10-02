package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class PrimaryXX(
    @SerializedName("applicable")
    val applicable: Boolean,
    @SerializedName("base")
    val base: Double,
    @SerializedName("multiplier")
    val multiplier: Int
)