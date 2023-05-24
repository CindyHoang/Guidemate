package com.cindyhoang.guidemate.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.model.ObjType
import com.cindyhoang.guidemate.data.repository.GuideRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class GuideListViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: GuideListViewModel
    private lateinit var repository: GuideRepository

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = mock()
        viewModel = GuideListViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun fetchGuides_success() = runBlocking {
        val expectedGuides = listOf(
            Guide(
                url = "url1",
                startDate = "startDate1",
                endDate = "endDate1",
                name = "name1",
                icon = "icon1",
                venue = null,
                objType = ObjType.guide,
                loginRequired = false
            ),
            Guide(
                url = "url2",
                startDate = "startDate2",
                endDate = "endDate2",
                name = "name2",
                icon = "icon2",
                venue = null,
                objType = ObjType.guide,
                loginRequired = false
            )
        )
        `when`(repository.getUpcomingGuides()).thenReturn(expectedGuides)

        viewModel.fetchGuides()

        // Wait for the data to be updated
        while (viewModel.guides.value == null) {
            // Wait for the LiveData to receive the updated value
            kotlinx.coroutines.delay(100)
        }

        // Assert the expected results
        val actualGuides = viewModel.guides.value
        assertEquals(expectedGuides, actualGuides)
    }
}
