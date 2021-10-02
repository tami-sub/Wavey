package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("dom")
    val dom: DomX
)