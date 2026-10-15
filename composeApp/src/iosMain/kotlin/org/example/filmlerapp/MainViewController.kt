package org.example.filmlerapp

import androidx.compose.ui.window.ComposeUIViewController
import org.example.filmlerapp.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initializeKoin()
    }
) {
    App()
}