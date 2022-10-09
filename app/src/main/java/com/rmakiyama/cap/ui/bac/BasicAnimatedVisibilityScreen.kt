@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.bac

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

@Composable
fun BasicAnimatedVisibilityRoute(
    onBackClick: () -> Unit,
) {
    BasicAnimatedVisibilityScreen(
        onBackClick = onBackClick,
    )
}

@Composable
fun BasicAnimatedVisibilityScreen(
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
                titleRes = R.string.prototype_title_bav,
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
            verticalArrangement = spacedBy(24.dp),
            contentPadding = innerPadding,
        ) {
            sampleItem { FirstStep() }
            sampleItem { TryMutableTransitionState() }
        }
    }
}

private fun LazyListScope.sampleItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    item {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            content()
        }
    }
}

@Composable
private fun FirstStep() {
    var visible by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            this@Row.AnimatedVisibility(visible = visible) {
                Text("Sample text.")
            }
        }
        Switch(
            checked = visible,
            onCheckedChange = { visible = !visible },
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun TryMutableTransitionState() {
    val state = remember {
        MutableTransitionState(false)
    }

    LaunchedEffect(Unit) {
        delay(500L)
        state.targetState = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(
            visibleState = state,
            enter = fadeIn(animationSpec = tween(durationMillis = 1_000)),
        ) {
            Text(text = "Hello, world!")
        }
        Text(
            text = "State: " + when {
                state.isIdle && state.currentState -> "Visible"
                !state.isIdle && state.currentState -> "Disappearing"
                state.isIdle && !state.currentState -> "Invisible"
                else -> "Appearing"
            }
        )
    }
}
