package com.abrahamlay.gojekclone.data.dtos


import com.abrahamlay.gojekclone.data.dtos.ResultVideo
import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<ResultVideo>?
)