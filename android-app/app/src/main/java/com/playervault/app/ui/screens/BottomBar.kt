package com.playervault.app.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.R
import com.playervault.app.ui.theme.Roboto
import com.playervault.app.ui.theme.Variables

// Las tres pestañas de la barra, con su texto y su icono (sacados de Figma)
enum class Pestana(val titulo: String, @DrawableRes val icono: Int) {
    COLECCION("Colección", R.drawable.ic_library),
    BUSCAR("Buscar", R.drawable.ic_search),
    PERFIL("Perfil", R.drawable.ic_user)
}

@Composable
fun BottomBar(
    pestanaActiva: Pestana,
    onPestanaClick: (Pestana) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Variables.surface)
            .border(width = 1.dp, color = Variables.outlineVariant)
            .padding(top = 12.dp, bottom = 16.dp)
    ) {
        // Un elemento por pestaña; weight(1f) hace que las tres ocupen lo mismo
        Pestana.entries.forEach { pestana ->
            BottomBarItem(
                pestana = pestana,
                activa = pestana == pestanaActiva,
                onClick = { onPestanaClick(pestana) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    pestana: Pestana,
    activa: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Colores según Figma: la pestaña activa tiene la "píldora" de fondo y colores más claros
    val fondoIndicador = if (activa) Variables.primaryContainer else Color.Transparent
    val colorIcono = if (activa) Variables.onPrimaryContainer else Variables.onSurfaceVariant
    val colorTexto = if (activa) Variables.onSurface else Variables.onSurfaceVariant

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { onClick() }
    ) {
        // Indicador: píldora de 64x32 con el icono centrado
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(64.dp)
                .height(32.dp)
                .background(color = fondoIndicador, shape = RoundedCornerShape(Variables.shapeFull))
        ) {
            Icon(
                painter = painterResource(pestana.icono),
                contentDescription = pestana.titulo,
                tint = colorIcono,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = pestana.titulo,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight(500),
                color = colorTexto,
            )
        )
    }
}

@Preview
@Composable
private fun BottomBarPrev() {
    var activa by remember { mutableStateOf(Pestana.COLECCION) }
    BottomBar(
        pestanaActiva = activa,
        onPestanaClick = { activa = it }
    )
}
