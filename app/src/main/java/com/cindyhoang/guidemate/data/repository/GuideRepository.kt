package com.cindyhoang.guidemate.data.repository

import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.network.GuideService
import javax.inject.Inject

class GuideRepository @Inject constructor(
    private val guideService: GuideService
) {
    private var cachedGuides: List<Guide> = emptyList()

    suspend fun getUpcomingGuides(): List<Guide> {
        if (cachedGuides.isEmpty()) {
            val response = guideService.getUpcomingGuides()
            if (response.isSuccessful) {
                val guideResponse = response.body()
                cachedGuides = guideResponse?.guides?.map { it } ?: emptyList()
            }
        }
        return cachedGuides
    }

    fun clearCachedGuides() {
        cachedGuides = emptyList()
    }
}