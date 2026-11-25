package com.playervault.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playervault.app.data.VideojuegoRepository
import com.playervault.app.model.Estado
import com.playervault.app.model.Videojuego
import com.playervault.app.ui.theme.Variables

@Composable
fun StatusChip (videojuego: Videojuego, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(8.dp)
            .background(
                color = Variables.estados[videojuego.estado.toString()] ?: Color.Gray,
                shape = CircleShape
            )
    )
}

@Preview
@Composable
private fun StatusChipPrev() {
    StatusChip(VideojuegoRepository.videojuegos[2])
}