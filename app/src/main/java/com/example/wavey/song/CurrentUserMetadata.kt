package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class CurrentUserMetadata(
    @SerializedName("excluded_permissions")
    val excludedPermissions: List<String>,
    @SerializedName("interactions")
    val interactions: Interactions,
    @SerializedName("iq_by_action")
    val iqByAction: IqByAction,
    @SerializedName("permissions")
    val permissions: List<String>,
    @SerializedName("relationships")
    val relationships: Relationships
)