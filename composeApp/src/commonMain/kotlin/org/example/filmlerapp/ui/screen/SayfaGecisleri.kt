package org.example.filmlerapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.example.filmlerapp.data.entity.Filmler

@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable("detaySayfa/{film}",
            arguments = listOf(
                navArgument("film"){type = NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("film")!!
            val nesne = Json.decodeFromString<Filmler>(json)
            DetaySayfa(navController = navController, gelenFilmler = nesne)
        }
    }
}