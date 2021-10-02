package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class StatsX(
    @SerializedName("accepted_annotations")
    val acceptedAnnotations: Int,
    @SerializedName("concurrents")
    val concurrents: Int,
    @SerializedName("contributors")
    val contributors: Int,
    @SerializedName("hot")
    val hot: Boolean,
    @SerializedName("iq_earners")
    val iqEarners: Int,
    @SerializedName("pageviews")
    val pageviews: Int,
    @SerializedName("transcribers")
    val transcribers: Int,
    @SerializedName("unreviewed_annotations")
    val unreviewedAnnotations: Int,
    @SerializedName("verified_annotations")
    val verifiedAnnotations: Int
)