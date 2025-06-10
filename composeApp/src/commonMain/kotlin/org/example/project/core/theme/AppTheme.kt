package org.example.project.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

internal val LightColorScheme = lightColorScheme(
    onPrimary = ColorOnPrimary,
    background = ColorBackground,
    onSurfaceVariant = ColorOnSurfaceVariant,
    surfaceVariant = ColorSurfaceVariant
)

internal val DarkColorScheme = darkColorScheme(
    primary = ColorBottomBarBackground,
    onPrimary = ColorOnPrimaryDark,
    background = ColorBackgroundDark,
    onSurfaceVariant = ColorOnSurfaceVariantDark,
    surfaceVariant = ColorSurfaceVariantDark,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){
    val colors = if (!darkTheme) LightColorScheme else DarkColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography(),
        content = content

    )
}
