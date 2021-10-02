package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class InteractionsX(
    @SerializedName("following")
    val following: Boolean
)