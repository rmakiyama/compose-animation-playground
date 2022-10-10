package com.rmakiyama.cap.ui.progress

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FourDotScaleProgress(
    modifier: Modifier = Modifier,
    circleSize: Dp = 16.dp,
) {
    @Composable
    fun Dot(color: Color, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .size(circleSize)
                .clip(CircleShape)
                .background(color),
        )
    }

    val infiniteTransition = rememberInfiniteTransition()
    val animatedValues = buildList {
        repeat(DotsCount) { index ->
            val factor by infiniteTransition.animateFloat(
                initialValue = 0.8f,
                targetValue = 0.98f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = AnimationDuration),
                    repeatMode = RepeatMode.Reverse,
                    initialStartOffset = StartOffset(
                        AnimationDuration / DotsCount * index
                    )
                )
            )
            add(factor)
        }
    }

    Row(
        modifier = modifier.height(circleSize),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(DotsCount) { index ->
            Dot(
                color = Colors[index],
                modifier = Modifier.scale(animatedValues[index]),
            )
        }
    }
}

private const val DotsCount = 4
private const val AnimationDuration = 500
private val Colors = listOf(Color.Red, Color.Blue, Color.Yellow, Color.Green)

@Preview
@Composable
private fun FourDotScaleProgressPreview() {
    FourDotScaleProgress()
}
