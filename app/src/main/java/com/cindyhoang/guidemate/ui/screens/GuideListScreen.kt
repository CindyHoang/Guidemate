package com.cindyhoang.guidemate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.ui.viewmodel.GuideListViewModel

@Composable
fun GuideListScreen(viewModel: GuideListViewModel, modifier: Modifier) {
    val guides by viewModel.guides.observeAsState(emptyList())
    
    LazyColumn(modifier = modifier) {
        items(guides) { guide ->
            GuideListItem(guide = guide)
        }
    }
}

@Composable
fun GuideListItem(guide: Guide) {
    Column(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()
    ) {
        Text(text = guide.name)
        Text(text = guide.startDate)
    }
}