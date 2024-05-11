package com.example.devoir_kotlin_api_sport.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.devoir_kotlin_api_sport.backend.MainViewModel
import com.example.devoir_kotlin_api_sport.ui.theme.Devoir_Kotlin_API_SportTheme
import com.example.devoir_kotlin_api_sport.backend.Choixstatus

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AccueilScreenPreview() {
    Devoir_Kotlin_API_SportTheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
        }
    }
}

//Composable représentant l'ensemble de l'écran
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Accueil(navHostController: NavHostController?= null,
            modifier: Modifier = Modifier,
            viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    Box(modifier = modifier
        .fillMaxSize()) {

        Surface(color = Color.White) {
            Column(modifier = Modifier.fillMaxSize().padding(0.dp,60.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = CenterHorizontally) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,) {
                    Text(
                        text = "Score du tournoi",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.1.sp,
                        )
                    )
                }
                Spacer(Modifier.size(70.dp))
                Box() {
                    Row(Modifier.fillMaxWidth().padding(15.dp,15.dp), horizontalArrangement = Arrangement.Start) {
                        // Passez viewModel à ButtonFiltre
                        ButtonFiltre(viewModel = viewModel, textValueOne = "En cours", textValueTwo =  "Terminé", textValueTree = "Tous")
                    }
                }
                AffichageMatch(viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonFiltre(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
                 modifier: Modifier = Modifier, textValueOne: String, textValueTwo: String,  textValueTree: String) {
    Box(
        modifier = Modifier.clickable {Choixstatus = "false"; viewModel.loadMatchStatus()}
            .border(
                width = 1.dp, // Largeur du contour
                color = Color.Black, // Couleur du contour
                shape = RoundedCornerShape(4.dp) // Forme du contour
            )
            .padding(8.dp) // Espace entre le contour et le texte
    ) {
        Text(
            text = textValueOne,
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.1.sp
            ),
        )
    }
    Spacer(Modifier.size(10.dp))
    Box(
        modifier = Modifier.clickable { Choixstatus = "true";viewModel.loadMatchStatus()}
            .border(
                width = 1.dp, // Largeur du contour
                color = Color.Black, // Couleur du contour
                shape = RoundedCornerShape(4.dp) // Forme du contour
            )
            .padding(8.dp) // Espace entre le contour et le texte
    ) {
        Text(
            text = textValueTwo,
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.1.sp,
            ),
        )
    }
    Spacer(Modifier.size(10.dp))
    Box(
        modifier = Modifier.clickable { Choixstatus = "";viewModel.loadMatchStatus()}
            .border(
                width = 1.dp, // Largeur du contour
                color = Color.Black, // Couleur du contour
                shape = RoundedCornerShape(4.dp) // Forme du contour
            )
            .padding(8.dp) // Espace entre le contour et le texte
    ) {
        Text(
            text = textValueTree,
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.1.sp,
            ),
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffichageMatch(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(), modifier: Modifier = Modifier, ) {
    val filterList = viewModel.myList

    if (filterList.isNotEmpty()) {
        LazyColumn(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(filterList) { item ->
                Box(
                    modifier = Modifier.padding(15.dp, 0.dp)
                        .border(
                            width = 2.dp, // Largeur du contour
                            color = Color.Black, // Couleur du contour
                            shape = RoundedCornerShape(4.dp) // Forme du contour
                        )
                        .background(Color.Gray)
                )
                {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(0.dp, 15.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.team1, // Affichage du nom de l'équipe 1
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                )
                            }
                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(
                                        text = "${item.score1}",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = if (item.termine) "Terminé" else "En cours",
                                        color = Color.Black,
                                        fontSize = 20.sp, // Taille de police différente ici
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = "${item.score2}",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.team2, // Affichage du nom de l'équipe 2
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                )
                            }
                        }
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text(
                                text = "${item.date}",
                                color = Color.Black,
                                fontSize = 12.sp,
                            )
                        }
                    }
                }
            }
        }
    }
    else {
        Row(Modifier.fillMaxWidth().padding(0.dp, 30.dp), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Aucun match trouvé",
                color = Color.Black,
                fontSize = 20.sp,
            )
        }
    }
}