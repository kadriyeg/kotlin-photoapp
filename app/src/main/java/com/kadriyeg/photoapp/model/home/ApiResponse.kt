package com.kadriyeg.photoapp.model.home


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)