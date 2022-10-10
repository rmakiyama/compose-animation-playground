package com.rmakiyama.cap.ui.progress

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun FlickrLikeProgress(
    modifier: Modifier = Modifier,
    circleSize: Dp = 60.dp,
) {
    @Composable
    fun Circle(color: Color, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .size(circleSize)
                .clip(CircleShape)
                .background(color),
        )
    }

    var reversed by remember { mutableStateOf(false) }
    val offset by animateDpAsState(
        targetValue = if (reversed) circleSize else 0.dp,
        animationSpec = tween(durationMillis = 600, easing = LinearEasing),
        finishedListener = { reversed = !reversed }
    )

    LaunchedEffect(Unit) {
        reversed = true
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Circle(
            color = Color.Red,
            modifier = Modifier
                .offset(x = offset)
                .zIndex(if (reversed) -1f else 1f),
        )
        Circle(
            color = Color.Blue,
            modifier = Modifier
                .offset(x = -offset)
                .zIndex(if (reversed) 1f else -1f),
        )
    }
}
