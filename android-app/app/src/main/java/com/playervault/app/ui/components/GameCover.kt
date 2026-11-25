package com.playervault.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playervault.app.R
import com.playervault.app.data.VideojuegoRepository
import com.playervault.app.model.Videojuego

@Composable
fun GameCover(videojuego: Videojuego, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(videojuego.caratula ?: R.drawable.ic_launcher_background),
        contentDescription = "Imagen del videojuego",
        modifier = modifier
            .width(56.dp)
            .height(76.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )

}

@Preview
@Composable
private fun GameCoverPrev() {
    GameCover(VideojuegoRepository.videojuegos[2])
}

