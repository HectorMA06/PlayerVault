package com.playervault.app.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Variables {
    val surfaceContainer: Color = Color(0xFF1E222B)
    val shapeLarge: Dp = 16.dp
    val spacingM: Dp = 12.dp
    val spacingL: Dp = 16.dp
    val onSurface: Color = Color(0xFFE8EAF0)
    val onSurfaceVariant: Color = Color(0xFF9AA3B2)
    val estadoJugandoContainer: Color = Color(0xFF11304A)
    val shapeFull: Dp = 999.dp
    val primary: Color = Color(0xFF7C5CFF)
    val onPrimary: Color = Color(0xFFFFFFFF)
    val surface: Color = Color(0xFF171A21)
    val shapeMedium: Dp = 12.dp
    val outline: Color = Color(0xFF3A4150)


    val estados = mapOf(
        "PENDIENTE" to pendiente,
        "JUGANDO" to jugando,
        "PASADO" to pasado,
        "ABANDONADO" to abandonado
    )

    val estadosContainer = mapOf(
        "PENDIENTE" to pendienteContainer,
        "JUGANDO" to jugandoContainer,
        "PASADO" to pasadoContainer,
        "ABANDONADO" to abandonadoContainer
    )
}