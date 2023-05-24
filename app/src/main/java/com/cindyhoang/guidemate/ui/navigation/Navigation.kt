package com.cindyhoang.guidemate.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cindyhoang.guidemate.ui.screens.GuideListScreen
import com.cindyhoang.guidemate.ui.viewmodel.GuideListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: GuideListViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fetchGuides()
    }

    Scaffold(
        topBar = { AppTitleBar() },
        content = { padding ->
            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    GuideListScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    )
}