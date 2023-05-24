package com.cindyhoang.guidemate.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GuidesResponse(
    @Json(name = "data")
    val guides: List<Guide>
)