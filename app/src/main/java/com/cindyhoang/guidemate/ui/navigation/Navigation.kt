package com.cindyhoang.guidemate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cindyhoang.guidemate.ui.screens.GuideListScreen
import com.cindyhoang.guidemate.ui.viewmodel.GuideListViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: GuideListViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fetchGuides()
    }

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            GuideListScreen(viewModel = viewModel)
        }
    }
}