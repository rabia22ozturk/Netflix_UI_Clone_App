package org.example.filmlerapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.filmlerapp.ui.screen.SayfaGecisleri
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            SayfaGecisleri()
        }
    }
}