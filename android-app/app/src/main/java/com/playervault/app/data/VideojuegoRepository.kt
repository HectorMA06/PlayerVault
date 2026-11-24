package com.playervault.app.data

import com.playervault.app.R
import com.playervault.app.model.Estado
import com.playervault.app.model.Videojuego

object VideojuegoRepository{
    val videojuegos = listOf(
        Videojuego(
            id = 1,
            titulo = "The Legend of Zelda: Ocarina of Time",
            genero = "Aventura",
            plataforma = "Nintendo Switch 2",
            estado = Estado.JUGANDO,
            puntuacion = 9.6,
            horas_jugadas = 10.4,
            fecha_lanzamiento = 1998,
            caratula = R.drawable.ic_zelda_ocarina
        ),
        Videojuego(
            id = 2,
            titulo = "Super Mario Bros. Wonder",
            genero = "Plataformas",
            plataforma = "Nintendo Switch 2",
            estado = Estado.PASADO,
            puntuacion = 9.6,
            horas_jugadas = 15.3,
            fecha_lanzamiento = 2023,
            caratula = R.drawable.ic_mario_wonder
        ),
        Videojuego(
            id = 3,
            titulo = "Doki Doki Literature Club",
            genero = "Novela visual",
            plataforma = "PC",
            puntuacion = 6.6,
            horas_jugadas = 12.3,
            fecha_lanzamiento = 2017,
            caratula = R.drawable.ic_doki_doki
        )

    )
}