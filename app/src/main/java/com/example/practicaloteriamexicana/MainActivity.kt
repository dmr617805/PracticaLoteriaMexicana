package com.example.practicaloteriamexicana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practicaloteriamexicana.ui.navigation.NavigationApp
import com.example.practicaloteriamexicana.ui.theme.PracticaLoteriaMexicanaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaLoteriaMexicanaTheme {
                NavigationApp()
            }
        }
    }
}

