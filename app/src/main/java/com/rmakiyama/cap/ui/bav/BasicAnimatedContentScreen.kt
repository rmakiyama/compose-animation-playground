@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.rmakiyama.cap.ui.bav

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.component.CapTopAppBar
import com.rmakiyama.cap.ui.extension.sampleItem

@Composable
fun BasicAnimatedContentRoute(
    onBackClick: () -> Unit,
) {
    BasicAnimatedContentScreen(
        onBackClick = onBackClick,
    )
}

@Composable
fun BasicAnimatedContentScreen(
    onBackClick: () -> Unit,
) {
    val listState = rememberLazyListState()
    val topAppBarCanScroll by remember {
        derivedStateOf {
            listState.layoutInfo.totalItemsCount > listState.layoutInfo.visibleItemsInfo.size
        }
    }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        canScroll = { topAppBarCanScroll }
    )
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CapTopAppBar(
                titleRes = R.string.prototype_title_bac,
                navigationIcon = Icons.TwoTone.ArrowBack,
                navigationIconContentDescription = "back to home",
                onNavigationClick = onBackClick,
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = innerPadding,
        ) {
            sampleItem { BasicSample() }
        }
    }
}

@Composable
fun BasicSample() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var count by remember { mutableStateOf(0) }
        AnimatedContent(targetState = count) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "$targetCount", style = MaterialTheme.typography.headlineMedium)
        }
        Button(onClick = { count++ }) {
            Text("Add")
        }
    }
}
