package com.robin.alcproject.models
import com.google.gson.annotations.SerializedName

data class IQItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("badgeUrl")
    val badgeUrl: String,

)