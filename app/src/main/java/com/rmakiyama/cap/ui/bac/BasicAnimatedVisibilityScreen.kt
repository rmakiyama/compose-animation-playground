@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.bac

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.rmakiyama.cap.R

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
            MediumTopAppBar(
                title = { Text(text = stringResource(id = R.string.prototype_title_bav)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.TwoTone.ArrowBack,
                            contentDescription = "back to home",
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            )
        }
    ) { innerPadding ->
        Text(
            text = stringResource(id = R.string.prototype_title_bav),
            modifier = Modifier.padding(innerPadding)
        )
    }
}
