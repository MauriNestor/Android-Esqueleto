package org.scesi.esqueleto.ui.screen.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import org.scesi.esqueleto.ui.navigation.NavFeature

@Composable
fun DetailScreen(navController: NavController) {

    Text(text ="Detail Screen")

    Button(onClick = { navController.navigate(NavFeature.Home) }) {
        Text("Go to Screen B")
    }
}