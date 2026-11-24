package com.playervault.app.ui.theme

import androidx.compose.ui.graphics.Color

// Colores sacados de la guía de estilo de Figma (página "Guía de estilo" > "Colores").
// Tema oscuro único: cada color se asigna a su rol de Material 3 en Theme.kt.

// --- Acento y error ---
val Primary = Color(0xFF7C5CFF)              // Acción principal, FAB, estrella
val OnPrimary = Color(0xFFFFFFFF)
val PrimaryContainer = Color(0xFF2B2257)     // Chip seleccionado, indicador de navegación
val OnPrimaryContainer = Color(0xFFCFC2FF)
val Error = Color(0xFFFF5C6C)                // Borrar, errores de validación

// --- Superficies (de mayor a menor profundidad) ---
val Background = Color(0xFF0F1115)           // Fondo de todas las pantallas
val Surface = Color(0xFF171A21)              // Barra de navegación, barra de acciones
val SurfaceContainer = Color(0xFF1E222B)     // Tarjetas de juego, recuadros de datos
val SurfaceContainerHigh = Color(0xFF272C37) // Barra de búsqueda, pista del slider

// --- Texto y bordes ---
val OnSurface = Color(0xFFE8EAF0)            // Texto principal
val OnSurfaceVariant = Color(0xFF9AA3B2)     // Texto secundario
val Outline = Color(0xFF3A4150)              // Borde de campos, chips sin seleccionar
val OutlineVariant = Color(0xFF2A2F3A)       // Separadores y divisores

// --- Estados del juego (enum Estado) ---
// color = punto y texto del chip · container = fondo del chip
val EstadoPendiente = Color(0xFFF5B544)
val EstadoPendienteContainer = Color(0xFF3A2E14)

val EstadoJugando = Color(0xFF3DB2FF)
val EstadoJugandoContainer = Color(0xFF11304A)

val EstadoPasado = Color(0xFF3DDC84)
val EstadoPasadoContainer = Color(0xFF123A26)

val EstadoAbandonado = Color(0xFFFF5C6C)
val EstadoAbandonadoContainer = Color(0xFF43171D)
