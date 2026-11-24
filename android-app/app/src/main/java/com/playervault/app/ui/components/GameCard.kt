package com.playervault.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.R
import com.playervault.app.data.VideojuegoRepository
import com.playervault.app.model.Videojuego
import com.playervault.app.ui.theme.PlayervaultTheme
import com.playervault.app.ui.theme.Variables

@Composable
fun GameCard(videojuego: Videojuego, modifier: Modifier = Modifier) {

    Row(
        Modifier
            .width(360.dp)
            .height(102.dp)
            .background(
                color = Variables.surfaceContainer,
                shape = RoundedCornerShape(size = Variables.shapeLarge)
            )
            .padding(
                start = Variables.spacingM,
                top = Variables.spacingM,
                end = Variables.spacingL,
                bottom = Variables.spacingM
            )
    ) {
        //CARATULA
        Image(
            painter = painterResource(videojuego.caratula ?: R.drawable.ic_launcher_background),
            contentDescription = "Imagen del videojuego",
            Modifier
                .width(56.dp)
                .height(76.dp)
        )
        Column(

        ) {
            //TITULO
            Text(
                text = videojuego.titulo,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(600),
                    color = Variables.onSurface,
                ),
                modifier = Modifier
                    .width(264.dp)
                    .height(22.dp)
            )

            Row(
                modifier = Modifier
                    .width(264.dp)
                    .height(20.dp)
            ) {
                //PLATAFORMA Y GENERO
                Text(
                    text = "${videojuego.plataforma} · ${videojuego.genero}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                        color = Variables.onSurfaceVariant,
                    )
                )
            }
            Row(

            ) {
                //ESTADO
                Row() {
                    Text(
                        text = videojuego.estado.name
                    )
                }

                //PUNTUACION
                Row() {
                    Image(
                        painter = painterResource(R.drawable.ic_rating),
                        contentDescription = "Icono de rating de videojuego",
                        modifier = Modifier.size(17.dp)
                    )
                    Text(
                        text = videojuego.puntuacion.toString()
                    )
                }
                //Horas jugadas
                Row() {
                    Image(
                        painter = painterResource(R.drawable.ic_time),
                        contentDescription = "Icono de reloj",
                        modifier = Modifier.size(17.dp)
                    )
                    Text(
                        text = videojuego.horas_jugadas.toString()
                    )
                }

            }
        }

    }

}

@Preview (showBackground = true)
@Composable
private fun GameCardPrev() {
    PlayervaultTheme {
        GameCard(VideojuegoRepository.videojuegos[0])
    }

}