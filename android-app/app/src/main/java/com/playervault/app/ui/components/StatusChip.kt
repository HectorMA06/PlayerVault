package com.playervault.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.data.VideojuegoRepository
import com.playervault.app.model.Videojuego
import com.playervault.app.ui.theme.Roboto
import com.playervault.app.ui.theme.Variables

@Composable
fun StatusChip (videojuego: Videojuego, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(24.dp)
            .background(
                color = Variables.estadosContainer[videojuego.estado.toString()] ?: Color.Gray,
                shape = RoundedCornerShape(size = Variables.shapeFull)
            )
            .padding(start = 10.dp, top = 4.dp, end = 10.dp, bottom = 4.dp)
    ) {
        Box(
            modifier = modifier
                .size(8.dp)
                .background(
                    color = Variables.estados[videojuego.estado.toString()] ?: Color.Gray,
                    shape = CircleShape
                )
        )
        Text(
            text = videojuego.estado.texto, style = TextStyle(
                fontSize = 11.sp, //Tamaño de texto
                lineHeight = 16.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight(600),
                color = Variables.estados[videojuego.estado.toString()] ?: Color.Gray,
                letterSpacing = 0.44.sp,
            ),
            maxLines = 1
        )

    }


}

@Preview (showBackground = true)
@Composable
private fun StatusChipPrev() {
    StatusChip(VideojuegoRepository.videojuegos[2])
}