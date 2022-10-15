package com.rmakiyama.cap.ui.playingcards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.ui.playingcards.model.Card
import com.rmakiyama.cap.ui.playingcards.model.CardNumber
import com.rmakiyama.cap.ui.playingcards.model.CardSuit

@Composable
fun Card(
    card: Card,
    modifier: Modifier = Modifier,
    width: Dp = DefaultCardWidth,
) {
    when (card) {
        Card.Joker -> JokerCard(
            modifier = modifier,
            width = width,
        )
        is Card.Number -> NumberCard(
            card = card,
            modifier = modifier,
            width = width,
        )
    }
}

@Composable
private fun NumberCard(
    card: Card.Number,
    modifier: Modifier = Modifier,
    width: Dp = DefaultCardWidth,
) {
    OutlinedCard(
        modifier = modifier.wrapContentSize(),
    ) {
        Box(
            modifier = Modifier
                .width(width)
                .aspectRatio(ratio = CardRatio)
        ) {
            NumberAndSuit(card = card)
            NumberAndSuit(
                card = card,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .rotate(180f),
            )
        }
    }
}

@Composable
private fun NumberAndSuit(
    card: Card.Number,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = card.number.value, fontWeight = FontWeight.Black)
        Text(text = card.suit.value)
    }
}

@Composable
private fun JokerCard(
    modifier: Modifier = Modifier,
    width: Dp = DefaultCardWidth,
) {
    OutlinedCard(
        modifier = modifier.wrapContentSize(),
    ) {
        Box(
            modifier = Modifier
                .width(width)
                .aspectRatio(ratio = CardRatio)
                .padding(8.dp),
        ) {
            Text(text = "🧞‍")
            Text(
                text = "🧞‍",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .rotate(180f),
            )
        }
    }
}

private val DefaultCardWidth = 128.dp
private const val CardRatio = 0.64f

@Preview
@Composable
private fun NumberCardPreview() {
    val card = Card.Number(
        number = CardNumber.TEN,
        suit = CardSuit.HEARTS,
    )
    NumberCard(card = card)
}

@Preview
@Composable
private fun JokerCardPreview() {
    JokerCard()
}
