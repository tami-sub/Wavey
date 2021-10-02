package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class CurrentUserMetadataX(
    @SerializedName("excluded_permissions")
    val excludedPermissions: List<Any>,
    @SerializedName("interactions")
    val interactions: InteractionsX,
    @SerializedName("permissions")
    val permissions: List<String>
)