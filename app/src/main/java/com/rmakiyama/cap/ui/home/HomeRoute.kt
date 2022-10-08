@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.home

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.theme.CapTheme
import com.rmakiyama.cap.model.Prototype

@Composable
fun HomeRoute() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    prototypes: List<Prototype> = com.rmakiyama.cap.model.prototypes,
) {
    Scaffold(
        topBar = { HomeTopAppBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = spacedBy(16.dp),
        ) {
            items(prototypes, key = { prototype -> prototype.title }) { prototype ->
                PrototypeItem(prototype = prototype)
            }
        }
    }
}

@Composable
fun HomeTopAppBar() {
    MediumTopAppBar(
        title = { Text(text = stringResource(id = R.string.title_home)) },
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    CapTheme {
        HomeScreen()
    }
}
