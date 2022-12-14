package com.rmakiyama.cap.model

sealed class Prototype {
    val route: String = this.javaClass.simpleName
}

object BasicAnimatedVisibility: Prototype()
object BasicAnimatedContent: Prototype()
object Progress: Prototype()
object PlayingCards: Prototype()

val prototypes = listOf(
    BasicAnimatedVisibility,
    BasicAnimatedContent,
    Progress,
    PlayingCards,
)
