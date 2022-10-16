package com.rmakiyama.cap.ui.playingcards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.rmakiyama.cap.ui.playingcards.model.Card
import com.rmakiyama.cap.ui.playingcards.model.PlayingCards

@Composable
fun Hands(
    cards: List<Card>,
    modifier: Modifier = Modifier,
) {
    Layout(
        modifier = modifier
            .wrapContentSize()
            .background(Color.Green),
        content = {
            cards.forEach { card ->
                Card(
                    card = card
                )
            }
        }
    ) { measurables, constraints ->

        val placeables = measurables.map {
            it.measure(constraints)
        }

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight,
        ) {
            placeables.forEachIndexed { index, placeable ->
                val positionX = constraints.maxWidth / 2 - placeable.width / 2
                placeable.placeRelativeWithLayer(
                    position = IntOffset(positionX, 0),
                    layerBlock = {
                        transformOrigin = TransformOrigin(
                            0.4f, 1f,
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
        playingCards.draw(),
        playingCards.draw(),
        playingCards.draw(),
        playingCards.draw(),
        playingCards.draw(),
    )
    Hands(cards = cards)
}
