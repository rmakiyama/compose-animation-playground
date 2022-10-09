@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.bac

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.component.CapTopAppBar

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
    Scaffold(
        topBar = {
            CapTopAppBar(
                titleRes = R.string.prototype_title_bav,
                navigationIcon = Icons.TwoTone.ArrowBack,
                navigationIconContentDescription = "back to home",
                onNavigationClick = onBackClick,
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            FirstStep()
        }
    }
}

@Composable
private fun FirstStep() {

}
