package com.playervault.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.ui.theme.Roboto
import com.playervault.app.ui.theme.Variables
import com.playervault.app.ui.theme.primaryContainer

@Composable
fun FilterChip(text: String,
               activado: Boolean,
               onClick: () -> Unit,
               modifier: Modifier = Modifier) {

    //Comprobaciones si está activado
    val fondo = if (activado) Variables.primaryContainer else Color.Transparent
    val colorTexto = if (activado) Variables.onPrimaryContainer else Variables.onSurfaceVariant
    val borde = if (activado) null else BorderStroke(1.dp, Variables.outline)

    Button(
        onClick = onClick,
        modifier = modifier.height(32.dp),
        shape = RoundedCornerShape(Variables.shapeSmall),
        colors = ButtonDefaults.buttonColors(
            containerColor = fondo,
            contentColor = colorTexto
        ),
        border = borde,
        //Cambia el padding dependiendo si está activado o no
        contentPadding = PaddingValues(
            start = if (activado) 10.dp else 12.dp,
            end = if (activado) 14.dp else 12.dp

    )){
        if (activado){
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(6.dp))
        }
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight(500)
            )
        )
    }
}

@Preview
@Composable
private fun FilterChipPrev() {
    var activado by remember { mutableStateOf(false) }
    FilterChip(
        text = "Prueba",
        activado = activado,
        onClick = {activado = !activado},
    )
}