package com.playervault.app.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.R
import com.playervault.app.data.VideojuegoRepository
import com.playervault.app.model.Videojuego
import com.playervault.app.ui.theme.PlayervaultTheme
import com.playervault.app.ui.theme.Roboto
import com.playervault.app.ui.theme.Variables
import com.playervault.app.ui.theme.pendiente
import com.playervault.app.ui.theme.primary


@Composable
fun GameCard(videojuego: Videojuego, modifier: Modifier = Modifier) {
    //La tarjeta entera
    Row(
        modifier
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
        GameCover(videojuego)
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
                text = videojuego.titulo,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(600),
                    color = Variables.onSurface,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            //PLATAFORMA Y GENERO
            Text(
                text = "${videojuego.plataforma} · ${videojuego.genero}", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Variables.onSurfaceVariant,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(

            ) {
                //INFO
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.height(24.dp)
                ) {
                    //Estado
                    StatusChip(videojuego)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(20.dp)
                    ) {
                        //Puntuación
                        Image(
                            painter = painterResource(R.drawable.ic_rating),
                            contentDescription = "Icono de rating de videojuego",
                            colorFilter = ColorFilter.tint(primary),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = videojuego.puntuacion?.toString() ?: "–",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = Roboto,
                                fontWeight = FontWeight(500),
                                color = Variables.onSurface,
                            ),
                            maxLines = 1
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(20.dp)
                    ) {
                        //Tiempo jugado
                        Image(
                            painter = painterResource(R.drawable.ic_time),
                            contentDescription = "Icono de reloj",
                            colorFilter = ColorFilter.tint(Variables.onSurfaceVariant),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "${videojuego.horas_jugadas} h",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = Roboto,
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
        GameCard(VideojuegoRepository.videojuegos[2])
    }

}