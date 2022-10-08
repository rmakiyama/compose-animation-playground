@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.rmakiyama.cap.R

@Composable
fun HomeRoute() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopAppBar() }
    ) { innerPadding ->
        Text(text = "todo", modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun HomeTopAppBar() {
    MediumTopAppBar(
        title = { Text(text = stringResource(id = R.string.title_home)) },
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
    )
}
