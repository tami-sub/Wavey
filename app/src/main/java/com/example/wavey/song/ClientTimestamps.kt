package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class ClientTimestamps(
    @SerializedName("lyrics_updated_at")
    val lyricsUpdatedAt: Int,
    @SerializedName("updated_by_human_at")
    val updatedByHumanAt: Int
)