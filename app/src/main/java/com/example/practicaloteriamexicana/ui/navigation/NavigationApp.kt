package com.example.practicaloteriamexicana.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicaloteriamexicana.ui.screens.HomeScreen
import com.example.practicaloteriamexicana.ui.screens.PlayScreen


@Composable
fun NavigationApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route  ){

        composable(Screen.Home.route){
            HomeScreen(navController)
        }

        composable(route = Screen.Play.route){
            PlayScreen(navController)
        }
    }
}