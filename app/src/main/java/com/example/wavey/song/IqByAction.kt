package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class IqByAction(
    @SerializedName("edit_metadata")
    val editMetadata: EditMetadata
)