package com.example.wavey.search


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("concurrents")
    val concurrents: Int,
    @SerializedName("hot")
    val hot: Boolean,
    @SerializedName("pageviews")
    val pageviews: Int,
    @SerializedName("unreviewed_annotations")
    val unreviewedAnnotations: Int
)