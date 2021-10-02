package com.example.wavey.search


import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("response")
    val response: Response
)