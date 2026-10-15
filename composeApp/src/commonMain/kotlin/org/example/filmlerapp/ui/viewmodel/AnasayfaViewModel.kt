package org.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.example.filmlerapp.data.entity.Filmler
import org.example.filmlerapp.data.repo.FilmlerRepository

class AnasayfaViewModel( var filmlerRepository : FilmlerRepository) : ViewModel() {
    var filmlerListesi = MutableStateFlow<List<Filmler>>(listOf())

    init {
        filmleriYukle()
    }

     fun filmleriYukle(){
         CoroutineScope(Dispatchers.Main).launch {
             filmlerListesi.value = filmlerRepository.filmleriYukle()
         }
     }
}