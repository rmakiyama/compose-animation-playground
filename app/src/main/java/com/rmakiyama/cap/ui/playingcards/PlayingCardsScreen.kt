@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.playingcards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.component.CapTopAppBar

@Composable
fun PlayingCardsRoute(
    onBackClick: () -> Unit,
) {
    PlayingCardsScreen(onBackClick)
}

@Composable
fun PlayingCardsScreen(
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
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            // TODO
        }
    }
}
