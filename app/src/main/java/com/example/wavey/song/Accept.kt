package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Accept(
    @SerializedName("primary")
    val primary: PrimaryX
)