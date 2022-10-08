package com.rmakiyama.cap.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rmakiyama.cap.designsystem.theme.CapTheme
import com.rmakiyama.cap.navigation.CapNavHost

@Composable
fun CapApp() {
    CapTheme {
        CapNavHost(
            navController = rememberNavController()
        )
    }
}
