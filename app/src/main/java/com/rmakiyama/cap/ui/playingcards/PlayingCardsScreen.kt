@file:OptIn(ExperimentalMaterial3Api::class)

package com.rmakiyama.cap.ui.playingcards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmakiyama.cap.R
import com.rmakiyama.cap.designsystem.component.CapTopAppBar
import com.rmakiyama.cap.ui.playingcards.model.Card
import com.rmakiyama.cap.ui.playingcards.model.PlayingCards

@Composable
fun PlayingCardsRoute(
    onBackClick: () -> Unit,
) {
    PlayingCardsScreen(onBackClick)
}

@Composable
fun PlayingCardsScreen(
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CapTopAppBar(
                titleRes = R.string.prototype_title_progress,
                navigationIcon = Icons.TwoTone.ArrowBack,
                navigationIconContentDescription = "back to home",
                onNavigationClick = onBackClick,
            )
        }
    ) { innerPadding ->

        var hands by remember {
            mutableStateOf(getNewHands())
        }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Hands(cards = hands)
                Spacer(modifier = Modifier.size(64.dp))
                Button(onClick = { hands = getNewHands() }) {
                    Text("Reset")
                }
            }
        }
    }
}

// for sample
private fun getNewHands(): List<Card> {
    return PlayingCards.build().apply { shuffle() }.draw(5)
}
