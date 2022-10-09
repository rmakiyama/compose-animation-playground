package com.rmakiyama.cap.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
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
    modifier: Modifier = Modifier,
    prototype: Prototype,
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
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
        )
    }
}
