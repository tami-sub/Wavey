package com.example.wavey.search


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("hits")
    val hits: List<Hit>
)