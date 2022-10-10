package com.rmakiyama.cap.ui.progress

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SquareFlipProgress(
    modifier: Modifier = Modifier,
    size: Dp = 60.dp,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val animateValueX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = AnimationDuration
                1f at AnimationDuration / 2 with FastOutSlowInEasing
                1f at AnimationDuration
            },
        )
    )
    val animateValueY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = AnimationDuration
                0f at AnimationDuration / 2
                1f at AnimationDuration with FastOutSlowInEasing
            },
        ),
    )

    Box(
        modifier = modifier.graphicsLayer {
            rotationX = 180f * animateValueX
            rotationY = 180f * animateValueY
        },
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color),
        )
    }
}

private const val AnimationDuration = 2_000

@Preview
@Composable
private fun SquareFlipProgressPreview() {
    SquareFlipProgress()
}
