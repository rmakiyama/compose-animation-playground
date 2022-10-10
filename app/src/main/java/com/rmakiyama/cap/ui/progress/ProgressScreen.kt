@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.progress

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.component.CapTopAppBar
import com.rmakiyama.cap.ui.extension.sampleItem

@Composable
fun ProgressRoute(
    onBackClick: () -> Unit,
) {
    ProgressScreen(onBackClick)
}

@Composable
fun ProgressScreen(
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CapTopAppBar(
                titleRes = R.string.prototype_title_progress,
                navigationIcon = Icons.TwoTone.ArrowBack,
                navigationIconContentDescription = "back to home",
                onNavigationClick = onBackClick,
            )
        }
    ) { innerPadding ->
        val sampleBackgroundColor = MaterialTheme.colorScheme.background
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = innerPadding,
        ) {
            sampleItem(backgroundColor = sampleBackgroundColor) { FlickrLikeProgress() }
        }
    }
}
