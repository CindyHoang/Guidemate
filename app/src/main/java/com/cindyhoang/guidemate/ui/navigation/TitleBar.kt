package com.cindyhoang.guidemate.ui.navigation

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cindyhoang.guidemate.R

@Composable
fun AppTitleBar() {
    val title = stringResource(id = R.string.app_name)

    TopAppBar(
        title = { Text(text = title) }
    )
}