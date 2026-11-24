package com.playervault.app.model

import androidx.annotation.DrawableRes

data class Videojuego(
    val id: Int,
    val titulo: String,
    val genero: String,
    val plataforma: String,
    val estado: Estado = Estado.PENDIENTE,
    val puntuacion: Double? = null,
    val horas_jugadas: Double = 0.0,
    val fecha_lanzamiento: Int? = null,
    @DrawableRes val caratula: Int? = null
){

}
