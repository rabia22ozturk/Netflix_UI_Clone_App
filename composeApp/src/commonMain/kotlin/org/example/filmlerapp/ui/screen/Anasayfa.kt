package org.example.filmlerapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import filmlerapp.composeapp.generated.resources.Res
import filmlerapp.composeapp.generated.resources.anadoluda
import filmlerapp.composeapp.generated.resources.django
import filmlerapp.composeapp.generated.resources.inception
import filmlerapp.composeapp.generated.resources.interstellar
import filmlerapp.composeapp.generated.resources.thehatefuleight
import filmlerapp.composeapp.generated.resources.thepianist
import kotlinx.coroutines.launch
import org.example.filmlerapp.data.entity.Filmler
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.filmlerapp.ui.viewmodel.AnasayfaViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(
    navController: NavController,
    anasayfaViewModel: AnasayfaViewModel = koinViewModel <AnasayfaViewModel>()

){

    val filmlerListesi = anasayfaViewModel.filmlerListesi.collectAsState()
    val resimler = hashMapOf(
        "django" to Res.drawable.django,
        "interstellar" to Res.drawable.interstellar,
        "inception" to Res.drawable.inception,
        "thehatefuleight" to Res.drawable.thehatefuleight,
        "thepianist" to Res.drawable.thepianist,
        "anadoluda" to Res.drawable.anadoluda,
    )

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Filmler") }) },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            columns = GridCells.Fixed(count = 2)                       // Yatayda iki kutucuk olacak.
        ){
            items (
                count = filmlerListesi.value.count(),
                itemContent = {              // 0,1,2,3,4,5
                    val film = filmlerListesi.value[it]
                    Card(modifier = Modifier.padding(all = 5.dp)){
                        Column(
                            modifier = Modifier.clickable {
                                val filmJson= Json.encodeToString(film)
                                navController.navigate("detaySayfa/$filmJson")
                            }
                        ) {
                            Image(
                                painter = painterResource(resimler[film.resim]!!),
                                contentDescription = "",
                                modifier = Modifier.size(200.dp,300.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(text = "${film.fiyat} ₺", fontSize = 24.sp)
                                Button(onClick = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(message = "${film.ad} sepete eklendi.")
                                    }
                                }){ Text(text = "Sepet") }
                            }

                        }
                    }
                }
            )
        }
    }
}