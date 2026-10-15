package org.example.filmlerapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import filmlerapp.composeapp.generated.resources.Res
import filmlerapp.composeapp.generated.resources.anadoluda
import filmlerapp.composeapp.generated.resources.django
import filmlerapp.composeapp.generated.resources.inception
import filmlerapp.composeapp.generated.resources.interstellar
import filmlerapp.composeapp.generated.resources.thehatefuleight
import filmlerapp.composeapp.generated.resources.thepianist
import org.example.filmlerapp.data.entity.Filmler
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetaySayfa(navController: NavController, gelenFilmler: Filmler){

    val resimler = hashMapOf(
        "django" to Res.drawable.django,
        "interstellar" to Res.drawable.interstellar,
        "inception" to Res.drawable.inception,
        "thehatefuleight" to Res.drawable.thehatefuleight,
        "thepianist" to Res.drawable.thepianist,
        "anadoluda" to Res.drawable.anadoluda,
    )


    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = gelenFilmler.ad) },
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}){
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
            }
        ) }
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(resimler[gelenFilmler.resim]!!),
                contentDescription = "",
                modifier = Modifier.size(200.dp,300.dp))

            Text(text = "${gelenFilmler.fiyat} ₺", fontSize = 50.sp)
        }
    }
}
