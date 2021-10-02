package com.example.wavey.search


import com.google.gson.annotations.SerializedName

data class Hit(
    @SerializedName("highlights")
    val highlights: List<Any>,
    @SerializedName("index")
    val index: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("type")
    val type: String
)