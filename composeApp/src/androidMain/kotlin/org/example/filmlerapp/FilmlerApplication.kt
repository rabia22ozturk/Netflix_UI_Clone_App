package org.example.filmlerapp

import android.app.Application
import org.example.filmlerapp.di.initializeKoin
import org.example.filmlerapp.di.initializeKoin

class FilmlerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }
}