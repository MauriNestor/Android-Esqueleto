package org.scesi.esqueleto.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import org.scesi.esqueleto.ui.navigation.Navigation
import org.scesi.esqueleto.ui.theme.EsqueletoTheme

@Composable
fun SkeletonApp() {
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