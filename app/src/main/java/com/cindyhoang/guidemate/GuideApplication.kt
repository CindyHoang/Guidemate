package com.cindyhoang.guidemate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GuideApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}