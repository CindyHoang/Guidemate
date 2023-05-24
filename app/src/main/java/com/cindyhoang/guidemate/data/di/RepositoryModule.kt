package com.cindyhoang.guidemate.data.di

import com.cindyhoang.guidemate.data.network.GuideService
import com.cindyhoang.guidemate.data.network.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGuideService(): GuideService {
        return NetworkClient.getGuideService()
    }
}