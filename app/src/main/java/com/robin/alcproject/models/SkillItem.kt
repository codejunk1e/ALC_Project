package com.robin.alcproject.models
import com.google.gson.annotations.SerializedName

data class SkillItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String
)