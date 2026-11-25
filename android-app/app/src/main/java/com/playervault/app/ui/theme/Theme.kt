package com.playervault.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val PlayerVaultColorScheme = darkColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    error = error,
    background = background,
    surface = surface,
    onSurface = onSurface,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    onSurfaceVariant = onSurfaceVariant,
    outline = outline,
    outlineVariant = outlineVariant
)

@Composable
fun PlayervaultTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PlayerVaultColorScheme,
        typography = Typography,
        content = content
    )
}
