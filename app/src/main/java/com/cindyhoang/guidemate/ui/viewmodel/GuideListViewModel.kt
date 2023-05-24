package com.cindyhoang.guidemate.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.repository.GuideRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GuideListViewModel: ViewModel() {
    private val repository = GuideRepository()

    private val _guides = MutableLiveData<List<Guide>>()
    val guides: LiveData<List<Guide>> = _guides

    fun fetchGuides() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getUpcomingGuides()
            }
            _guides.value = result
        }
    }

    fun clearCache() {
        repository.clearCachedGuides()
    }
}