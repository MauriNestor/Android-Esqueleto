package org.scesi.esqueleto.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.scesi.domain.models.teams.CourseSchedule
import org.scesi.esqueleto.ui.navigation.NavFeature

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = koinViewModel()
    val schedules by viewModel.schedules.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { navController.navigate(NavFeature.Detail) }) {
            Text("Go to Screen B")
        }

        Text(text = "Lista de Horarios", style = MaterialTheme.typography.headlineMedium)

        if (schedules.isEmpty()) {
            Text(text = "Cargando...", modifier = Modifier.padding(top = 16.dp))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                items(schedules) { schedule ->
                    ScheduleItem(schedule)
                }
            }
        }
    }
}

@Composable
fun ScheduleItem(schedule: CourseSchedule) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nivel: ${schedule.levels.joinToString { it.code }}", style = MaterialTheme.typography.bodyLarge)
            schedule.levels.forEach { level ->
                Text(text = "Materias:", style = MaterialTheme.typography.bodyMedium)
                level.subjects.forEach { subject ->
                    Text(text = "- ${subject.name}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
