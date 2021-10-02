package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class EditMetadata(
    @SerializedName("primary")
    val primary: Primary
)