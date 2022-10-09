@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@Composable
fun CapTopAppBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector? = null,
    navigationIconContentDescription: String? = null,
    onNavigationClick: () -> Unit = {},
    actionIcon: ImageVector? = null,
    actionIconContentDescription: String? = null,
    onActionClick: () -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    MediumTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        modifier = modifier,
        navigationIcon = {
            navigationIcon?.let { iconVector ->
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = navigationIconContentDescription,
                    )
                }
            }
        },
        actions = {
            actionIcon?.let { iconVector ->
                IconButton(onClick = onActionClick) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = actionIconContentDescription,
                    )
                }
            }
        },
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}
