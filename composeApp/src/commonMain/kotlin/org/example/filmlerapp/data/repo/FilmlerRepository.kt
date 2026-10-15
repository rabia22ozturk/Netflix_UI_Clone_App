package org.example.filmlerapp.data.repo

import org.example.filmlerapp.data.datasource.FilmlerDataSource
import org.example.filmlerapp.data.entity.Filmler

class FilmlerRepository(var filmlerDataSource : FilmlerDataSource) {

    suspend fun filmleriYukle():List <Filmler> = filmlerDataSource.filmleriYukle()
}