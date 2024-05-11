package com.example.devoir_kotlin_api_sport.backend

sealed class Screen(val route: String) {
    object Accueil : Screen(route = "accueil")
}

