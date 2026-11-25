package com.playervault.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

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
import com.playervault.app.ui.theme.primary

@Composable
fun GameCard(videojuego: Videojuego, modifier: Modifier = Modifier) {
    //La tarjeta entera
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
            ),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        //CARATULA
        Image(
            painter = painterResource(videojuego.caratula ?: R.drawable.ic_launcher_background),
            contentDescription = "Imagen del videojuego",
            Modifier
                .width(56.dp)
                .height(76.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        //Informacion del juego
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .width(264.dp)
                .height(78.dp)
        ) {
            //TITULO
            Text(
                text = videojuego.titulo, style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(600),
                    color = Variables.onSurface,
                ), modifier = Modifier
                    .width(264.dp)
                    .height(22.dp)
            )

            //PLATAFORMA Y GENERO
            Text(
                text = "${videojuego.plataforma} · ${videojuego.genero}", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = Variables.onSurfaceVariant,
                ), modifier = Modifier
                    .width(264.dp)
                    .height(20.dp)
            )

            Row(

            ) {
                //INFO
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(208.dp)
                        .height(24.dp)
                ) {
                    //Estado
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(88.dp)
                            .height(24.dp)
                            .background(
                                color = Variables.estadoJugandoContainer,
                                shape = RoundedCornerShape(size = Variables.shapeFull)
                            )
                            .padding(start = 10.dp, top = 4.dp, end = 10.dp, bottom = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_dot),
                            contentDescription = "estado",
                            contentScale = ContentScale.None,
                            modifier = Modifier
                                .padding(1.dp)
                                .width(8.dp)
                                .height(8.dp)
                                .background(color = Variables.estadoJugando)
                        )
                        Text(
                            text = videojuego.estado.name, style = TextStyle(
                                fontSize = 11.sp, //Tamaño de texto
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(600),
                                color = Variables.estadoJugando,
                                letterSpacing = 0.44.sp,
                            ), modifier = Modifier
                                .width(54.dp)
                                .height(16.dp)

                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(38.dp)
                            .height(20.dp)
                    ) {
                        //Puntuación
                        Image(
                            painter = painterResource(R.drawable.ic_rating),
                            contentDescription = "Icono de rating de videojuego",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp)
                        )
                        Text(
                            text = videojuego.puntuacion.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(500),
                                color = Variables.onSurface,
                            ),
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(58.dp)
                            .height(20.dp)
                    ) {
                        //Tiempo jugado
                        Image(
                            painter = painterResource(R.drawable.ic_time),
                            contentDescription = "Icono de reloj",
                            modifier = Modifier
                                .width(14.dp)
                                .height(14.dp),
                            contentScale = ContentScale.None
                        )
                        Text(
                            text = videojuego.horas_jugadas.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(500),
                                color = Variables.onSurface,
                            )
                        )
                    }

                }
            }
        }

    }

}

@Preview()
@Composable
private fun GameCardPrev() {
    PlayervaultTheme {
        GameCard(VideojuegoRepository.videojuegos[0])
    }

}