package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class SongRelationship(
    @SerializedName("relationship_type")
    val relationshipType: String,
    @SerializedName("songs")
    val songs: List<SongXX>,
    @SerializedName("type")
    val type: String
)