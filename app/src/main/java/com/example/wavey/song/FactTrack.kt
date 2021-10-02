package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class FactTrack(
    @SerializedName("button_text")
    val buttonText: String,
    @SerializedName("external_url")
    val externalUrl: String,
    @SerializedName("help_link_text")
    val helpLinkText: String,
    @SerializedName("help_link_url")
    val helpLinkUrl: String,
    @SerializedName("provider")
    val provider: String
)