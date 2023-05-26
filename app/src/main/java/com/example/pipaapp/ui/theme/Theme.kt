package com.example.compose

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.example.pipaapp.ui.theme.pipaTypography

// Material 3 color schemes
private val pipaDarkColorScheme = darkColorScheme(
    primary = pipaDarkPrimary,
    onPrimary = pipaDarkOnPrimary,
    primaryContainer = pipaDarkPrimaryContainer,
    onPrimaryContainer = pipaDarkOnPrimaryContainer,
    inversePrimary = pipaDarkPrimaryInverse,
    secondary = pipaDarkSecondary,
    onSecondary = pipaDarkOnSecondary,
    secondaryContainer = pipaDarkSecondaryContainer,
    onSecondaryContainer = pipaDarkOnSecondaryContainer,
    tertiary = pipaDarkTertiary,
    onTertiary = pipaDarkOnTertiary,
    tertiaryContainer = pipaDarkTertiaryContainer,
    onTertiaryContainer = pipaDarkOnTertiaryContainer,
    error = pipaDarkError,
    onError = pipaDarkOnError,
    errorContainer = pipaDarkErrorContainer,
    onErrorContainer = pipaDarkOnErrorContainer,
    background = pipaDarkBackground,
    onBackground = pipaDarkOnBackground,
    surface = pipaDarkSurface,
    onSurface = pipaDarkOnSurface,
    inverseSurface = pipaDarkInverseSurface,
    inverseOnSurface = pipaDarkInverseOnSurface,
    surfaceVariant = pipaDarkSurfaceVariant,
    onSurfaceVariant = pipaDarkOnSurfaceVariant,
    outline = pipaDarkOutline
)

private val pipaLightColorScheme = lightColorScheme(
    primary = pipaLightPrimary,
    onPrimary = pipaLightOnPrimary,
    primaryContainer = pipaLightPrimaryContainer,
    onPrimaryContainer = pipaLightOnPrimaryContainer,
    inversePrimary = pipaLightPrimaryInverse,
    secondary = pipaLightSecondary,
    onSecondary = pipaLightOnSecondary,
    secondaryContainer = pipaLightSecondaryContainer,
    onSecondaryContainer = pipaLightOnSecondaryContainer,
    tertiary = pipaLightTertiary,
    onTertiary = pipaLightOnTertiary,
    tertiaryContainer = pipaLightTertiaryContainer,
    onTertiaryContainer = pipaLightOnTertiaryContainer,
    error = pipaLightError,
    onError = pipaLightOnError,
    errorContainer = pipaLightErrorContainer,
    onErrorContainer = pipaLightOnErrorContainer,
    background = pipaLightBackground,
    onBackground = pipaLightOnBackground,
    surface = pipaLightSurface,
    onSurface = pipaLightOnSurface,
    inverseSurface = pipaLightInverseSurface,
    inverseOnSurface = pipaLightInverseOnSurface,
    surfaceVariant = pipaLightSurfaceVariant,
    onSurfaceVariant = pipaLightOnSurfaceVariant,
    outline = pipaLightOutline
)

@Composable
fun PipaAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val pipaColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> pipaDarkColorScheme
        else -> pipaLightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = pipaColorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = pipaColorScheme,
        typography = pipaTypography,
        content = content
    )
}