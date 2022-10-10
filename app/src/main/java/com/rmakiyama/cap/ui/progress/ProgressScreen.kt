@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            sampleItem(backgroundColor = sampleBackgroundColor) {
                FlickrLikeProgress()
            }
            sampleItem(backgroundColor = sampleBackgroundColor) {
                FourDotScaleProgress()
            }
            sampleItem(backgroundColor = sampleBackgroundColor) {
                SquareScaleProgress()
            }
            sampleItem(backgroundColor = sampleBackgroundColor) {
                SquareFlipProgress()
            }
        }
    }
}
