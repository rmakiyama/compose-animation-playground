package com.rmakiyama.cap.model

sealed class Prototype {
    val route: String = this.javaClass.simpleName
}

object BasicAnimatedVisibility: Prototype()
object BasicAnimatedContent: Prototype()

val prototypes = listOf(
    BasicAnimatedVisibility,
    BasicAnimatedContent,
)
