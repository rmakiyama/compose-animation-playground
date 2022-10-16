package com.rmakiyama.cap.ui.playingcards.model

enum class CardNumber(val value: String) {
    ACE("A"),
    DEUCE("2"),
    TREY("3"),
    CATER("4"),
    CINQUE("5"),
    SICE("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
}

enum class CardSuit(val value: String) {
    HEARTS("♥️"),
    DIAMONDS("♦️"),
    CLOVERS("♣️"),
    SPADES("♠️"),
}

sealed class Card {
    data class Number(val number: CardNumber, val suit: CardSuit) : Card()
    object JokerA : Card()
    object JokerB : Card()
}

class PlayingCards(
    private val innerList: MutableList<Card>,
) : List<Card> by innerList {

    fun shuffle() {
        innerList.shuffle()
    }

    fun draw(): Card {
        require(innerList.isNotEmpty())
        return innerList.removeAt(0)
    }

    companion object {
        fun build(withJoker: Boolean = true): PlayingCards {
            val cards: MutableList<Card> = CardSuit.values().map { suit ->
                CardNumber.values().map { number -> Card.Number(number, suit) }
            }.flatten().toMutableList()
            if (withJoker) cards.addAll(listOf(Card.JokerA, Card.JokerB))
            return PlayingCards(cards)
        }
    }
}
