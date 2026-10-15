package org.example.filmlerapp.di

import org.example.filmlerapp.data.datasource.FilmlerDataSource
import org.example.filmlerapp.data.repo.FilmlerRepository
import org.example.filmlerapp.ui.viewmodel.AnasayfaViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single { FilmlerDataSource() } // data source alttaki repositorye get fonksiyonuna gidecek
    single { FilmlerRepository(get()) }// repository alttaki AnasayfaViewModelin  get fonksiyonuna gidecek

    viewModel { AnasayfaViewModel(get()) }
}

fun initializeKoin(config:KoinAppDeclaration?= null) =
    startKoin{
        config?.invoke(this)
        modules(appModule)
    }