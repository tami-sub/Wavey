package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class CurrentUserMetadataXX(
    @SerializedName("excluded_permissions")
    val excludedPermissions: List<String>,
    @SerializedName("interactions")
    val interactions: InteractionsXX,
    @SerializedName("iq_by_action")
    val iqByAction: IqByActionX,
    @SerializedName("permissions")
    val permissions: List<String>
)