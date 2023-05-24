package com.cindyhoang.guidemate.data.network

import com.cindyhoang.guidemate.data.model.GuidesResponse
import retrofit2.Response
import retrofit2.http.GET

interface GuideService {
    @GET("upcomingGuides")
    suspend fun getUpcomingGuides(): Response<GuidesResponse>
}