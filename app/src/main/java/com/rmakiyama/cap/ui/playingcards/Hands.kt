package com.rmakiyama.cap.ui.playingcards

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.ui.playingcards.model.Card
import com.rmakiyama.cap.ui.playingcards.model.PlayingCards

@Composable
fun Hands(
    cards: List<Card>,
    modifier: Modifier = Modifier,
    cardWidth: Dp = DefaultCardWidth,
) {
    Layout(
        modifier = modifier.wrapContentSize(),
        content = {
            cards.forEach { card ->
                Card(card = card, width = cardWidth)
            }
        }
    ) { measurables, constraints ->

        val placeables = measurables.map {
            it.measure(constraints)
        }

        // TODO: calculate width and height.

        val card = placeables.first()
        layout(
            width = card.measuredWidth,
            height = card.measuredHeight,
        ) {
            placeables.forEachIndexed { index, placeable ->

                placeable.placeRelativeWithLayer(
                    position = IntOffset.Zero,
                    layerBlock = {
                        transformOrigin = TransformOrigin(
                            transformPivotFractionX, 1f,
                        )
                        rotationZ = calculateRotationZ(
                            cardsSize = cards.size,
                            index = index,
                        )
                    }
                )
            }
        }
    }
}

private fun calculateRotationZ(
    cardsSize: Int,
    index: Int,
): Float {
    if (cardsSize == 1) return 0f
    val leastRotationZ = -rotationDiff / 2 * (cardsSize - 1)
    return leastRotationZ + rotationDiff * index
}

private val DefaultCardWidth = 128.dp
private const val transformPivotFractionX = 0.4f
private const val rotationDiff = 15f

@Preview
@Composable
private fun HandsPreview() {
    val playingCards = remember {
        PlayingCards.build().apply { shuffle() }
    }
    val cards = listOf(
        playingCards.draw(),
        playingCards.draw(),
        playingCards.draw(),
    )
    Hands(cards = cards)
}
