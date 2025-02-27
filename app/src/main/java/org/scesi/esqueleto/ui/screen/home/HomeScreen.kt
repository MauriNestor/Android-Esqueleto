package org.scesi.esqueleto.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import org.scesi.esqueleto.ui.navigation.NavFeature

@Composable
fun HomeScreen(navController: NavController ) {
    val viewModel: HomeViewModel = koinViewModel()
    val teams by viewModel.teams.collectAsState()


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Button(onClick = { navController.navigate(NavFeature.Detail) }) {
            Text("Go to Screen B")
        }
        Text(text = "Lista de Equipos", style = MaterialTheme.typography.headlineMedium)

        if (teams.isEmpty()) {
            Text(text = "Cargando...", modifier = Modifier.padding(top = 16.dp))
        } else {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)) {
                items(teams) { team ->
                    TeamItem(teamName = team.name)
                }
            }
        }
    }
}

@Composable
fun TeamItem(teamName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = teamName,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
