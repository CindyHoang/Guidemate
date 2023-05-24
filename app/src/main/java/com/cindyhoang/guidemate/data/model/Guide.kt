package com.cindyhoang.guidemate.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Guide (
    @Json(name = "url")
    val url: String,
    @Json(name = "startDate")
    val startDate: String,
    @Json(name = "endDate")
    val endDate: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "venue")
    val venue: Venue?,
    @Json(name = "objType")
    val objType: ObjType,
    @Json(name = "loginRequired")
    val loginRequired: Boolean
)

@JsonClass(generateAdapter = true)
data class Venue(
    @Json(name = "city")
    val city: String?,
    @Json(name = "state")
    val state: String?
)

enum class ObjType {
    guide
}