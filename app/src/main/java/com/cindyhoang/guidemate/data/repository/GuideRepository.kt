package com.cindyhoang.guidemate.data.repository

import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.network.NetworkClient

class GuideRepository {
    private val guideService = NetworkClient.getGuideService()
    private var cachedGuides: List<Guide>? = null

    suspend fun getUpcomingGuides(): List<Guide> {
        if (cachedGuides == null) {
            val response = guideService.getUpcomingGuides()
            if (response.isSuccessful) {
                val guideResponse = response.body()
                cachedGuides = guideResponse?.guides?.map {it}
            }
        }
        return cachedGuides ?: emptyList()
    }

    fun clearCachedGuides() {
        cachedGuides = null
    }
}