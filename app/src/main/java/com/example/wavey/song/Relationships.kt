package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("pinned_role")
    val pinnedRole: Any
)