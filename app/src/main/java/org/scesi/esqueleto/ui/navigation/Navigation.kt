package org.scesi.esqueleto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.scesi.esqueleto.ui.screen.HomeScreen

@Composable
fun Navigation(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavFeature.Home
    ){
        home(navHostController)
    }
}

private fun NavGraphBuilder.home(navHostController: NavHostController) {
    composable<NavFeature.Home>{
        HomeScreen()
    }
}