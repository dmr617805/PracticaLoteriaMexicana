package com.example.practicaloteriamexicana.ui.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("home")
    data object Play: Screen("play")
}