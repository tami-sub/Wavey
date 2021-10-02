package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class Annotation(
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("authors")
    val authors: List<Author>,
    @SerializedName("body")
    val body: Body,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("community")
    val community: Boolean,
    @SerializedName("cosigned_by")
    val cosignedBy: List<Any>,
    @SerializedName("current_user_metadata")
    val currentUserMetadata: CurrentUserMetadataXX,
    @SerializedName("custom_preview")
    val customPreview: Any,
    @SerializedName("has_voters")
    val hasVoters: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("pinned")
    val pinned: Boolean,
    @SerializedName("rejection_comment")
    val rejectionComment: Any,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("source")
    val source: Any,
    @SerializedName("state")
    val state: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("verified")
    val verified: Boolean,
    @SerializedName("verified_by")
    val verifiedBy: Any,
    @SerializedName("votes_total")
    val votesTotal: Int
)