package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class InteractionsXX(
    @SerializedName("cosign")
    val cosign: Boolean,
    @SerializedName("pyong")
    val pyong: Boolean,
    @SerializedName("vote")
    val vote: Any
)