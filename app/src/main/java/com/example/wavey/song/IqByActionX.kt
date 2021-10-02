package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class IqByActionX(
    @SerializedName("accept")
    val accept: Accept,
    @SerializedName("delete")
    val delete: Delete,
    @SerializedName("reject")
    val reject: Reject
)