package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("hot")
    val hot: Boolean,
    @SerializedName("pageviews")
    val pageviews: Int,
    @SerializedName("unreviewed_annotations")
    val unreviewedAnnotations: Int
)