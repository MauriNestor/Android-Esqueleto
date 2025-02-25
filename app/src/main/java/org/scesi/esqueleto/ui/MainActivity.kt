package org.scesi.esqueleto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.scesi.esqueleto.ui.SkeletonApp
import org.scesi.esqueleto.ui.theme.EsqueletoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkeletonApp()
        }
    }
}
