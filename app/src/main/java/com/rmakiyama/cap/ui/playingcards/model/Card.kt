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
    object Joker : Card()
}
