package org.scesi.esqueleto.ui

import android.util.Log
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.scesi.esqueleto.data.server.RemoteConnection
import org.scesi.esqueleto.ui.navigation.Navigation
import org.scesi.esqueleto.ui.theme.EsqueletoTheme

@Composable
fun SkeletonApp() {
    LaunchedEffect(Unit) {
        try {
            val teams = withContext(Dispatchers.IO) {
                RemoteConnection.service.getTeams()
            }
            Log.d("API_TEST", "Equipos obtenidos: $teams") // Ver en Logcat
        } catch (e: Exception) {
            Log.e("API_TEST", "Error al obtener equipos", e)
        }
    }

    val appState = rememberEsqueletoState()
    EsqueletoScreen{
        Navigation(
            navHostController = appState.navController,
        )
    }
}

@Composable
fun EsqueletoScreen(content: @Composable () -> Unit) {
    EsqueletoTheme{
        Surface {
            content()
        }
    }

}