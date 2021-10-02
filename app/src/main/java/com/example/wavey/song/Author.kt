package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("attribution")
    val attribution: Double,
    @SerializedName("pinned_role")
    val pinnedRole: Any,
    @SerializedName("user")
    val user: User
)