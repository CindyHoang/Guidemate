package com.cindyhoang.guidemate.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.repository.GuideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GuideListViewModel @Inject constructor(
    private val repository: GuideRepository
): ViewModel() {

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