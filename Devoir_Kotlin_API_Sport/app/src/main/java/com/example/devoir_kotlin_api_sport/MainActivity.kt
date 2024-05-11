package com.example.devoir_kotlin_api_sport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.devoir_kotlin_api_sport.backend.MainViewModel
import com.example.devoir_kotlin_api_sport.backend.Screen
import com.example.devoir_kotlin_api_sport.ui.screen.Accueil
import com.example.devoir_kotlin_api_sport.ui.theme.Devoir_Kotlin_API_SportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Devoir_Kotlin_API_SportTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    //ViewModel qui sera partagé entre les différentes routes
    val viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    NavHost(navController = navController, startDestination = Screen.Accueil.route) {
        //Route 1
        composable(Screen.Accueil.route) {
            Accueil(navHostController = navController, viewModel = viewModel)
        }
    }
}