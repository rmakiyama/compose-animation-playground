package com.rmakiyama.cap.ui.progress

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SquareScaleProgress(
    modifier: Modifier = Modifier,
    size: Dp = 60.dp,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val animateValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = AnimationDuration),
        )
    )

    val sizePx = with(LocalDensity.current) { size.toPx() }

    Canvas(
        modifier = modifier
            .size(size)
            .graphicsLayer {
                translationX = -sizePx * animateValue
            },
    ) {
        rotate(
            degrees = 90f * animateValue,
            pivot = Offset(sizePx, sizePx),
        ) {
            drawRect(
                color = color,
                size = Size(sizePx, sizePx),
            )
        }
    }
}

private const val AnimationDuration = 1_000

@Preview
@Composable
private fun SquareScaleProgressPreview() {
    SquareScaleProgress()
}
