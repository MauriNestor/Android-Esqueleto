package org.scesi.esqueleto.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberEsqueletoState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): EsqueletoState = remember (navController, coroutineScope)
{
    EsqueletoState(navController, coroutineScope)
}

class EsqueletoState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {
    // Add state here
}