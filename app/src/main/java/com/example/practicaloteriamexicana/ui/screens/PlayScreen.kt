package com.example.practicaloteriamexicana.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



@Composable
fun PlayScreen(navController: NavController) {

    val context = LocalContext.current

    val imageIds = remember {
        mutableStateListOf<Int>().apply {
            for (i in 1..53) {
                val imageId = getImageIdByName("image_$i", context)
                if (imageId != 0) add(imageId)
            }
        }
    }

    var selectedImage by remember { mutableIntStateOf(imageIds.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = selectedImage),
            contentDescription = "carta",
            modifier = Modifier.fillMaxWidth(0.85f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (imageIds.isNotEmpty()) {
                    selectedImage = imageIds.random()
                    imageIds.remove(selectedImage)
                }
            },
            modifier = Modifier.fillMaxWidth(0.85f),
            enabled = imageIds.isNotEmpty()
        ) {
            Text("Carta Siguiente")
        }

        if (imageIds.isEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("No hay más cartas disponibles el juego ha terminado.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            Text("Terminar Juego")
        }

    }
}


fun getImageIdByName(imageName: String, context: Context): Int {
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
        .let { resourceId ->
            if (resourceId != 0) resourceId else 0
        }
}

@Preview(showBackground = true)
@Composable
fun PlayScreenPreview() {
    val navController = rememberNavController()
    PlayScreen(navController)
}
