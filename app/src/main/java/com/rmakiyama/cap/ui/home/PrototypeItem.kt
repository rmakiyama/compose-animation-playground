@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.designsystem.theme.CapTheme
import com.rmakiyama.cap.model.BasicAnimatedVisibility
import com.rmakiyama.cap.model.Prototype
import com.rmakiyama.cap.ui.extension.title

@Composable
fun PrototypeItem(
    prototype: Prototype,
    onPrototypeClick: (Prototype) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        onClick = { onPrototypeClick(prototype) },
        modifier = modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            Text(text = stringResource(prototype.title))
        }
    }
}

@Preview
@Composable
private fun SampleItemPreview() {
    CapTheme {
        PrototypeItem(
            prototype = BasicAnimatedVisibility,
            onPrototypeClick = {},
        )
    }
}
