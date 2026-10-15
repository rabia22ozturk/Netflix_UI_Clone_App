package org.example.filmlerapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform