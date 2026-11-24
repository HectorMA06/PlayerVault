package com.playervault.app.model

enum class Estado(val texto: String) {
    PENDIENTE("Pendiente"),
    JUGANDO("Jugando"),
    PASADO("Pasado"),
    ABANDONADO("Abandonado")
}