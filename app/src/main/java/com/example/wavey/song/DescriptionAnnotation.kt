package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class DescriptionAnnotation(
    @SerializedName("annotatable")
    val annotatable: Annotatable,
    @SerializedName("annotations")
    val annotations: List<Annotation>,
    @SerializedName("annotator_id")
    val annotatorId: Int,
    @SerializedName("annotator_login")
    val annotatorLogin: String,
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("classification")
    val classification: String,
    @SerializedName("fragment")
    val fragment: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_description")
    val isDescription: Boolean,
    @SerializedName("path")
    val path: String,
    @SerializedName("range")
    val range: Range,
    @SerializedName("song_id")
    val songId: Int,
    @SerializedName("_type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("verified_annotator_ids")
    val verifiedAnnotatorIds: List<Any>
)