package com.example.pipaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.PipaAppTheme
import com.example.pipaapp.ui.PipaApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PipaAppTheme {
                val windowsSize = calculateWindowSizeClass(activity = this)
                PipaApp(windowsSize = windowsSize.widthSizeClass)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PipaAppPreview() {
    PipaAppTheme {
        PipaApp(windowsSize = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PipaAppMediumPreview() {
    PipaAppTheme {
        PipaApp(windowsSize = WindowWidthSizeClass.Medium)
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PipaAppExpandedPreview() {
    PipaAppTheme() {
        PipaApp(windowsSize = WindowWidthSizeClass.Expanded)
    }
}