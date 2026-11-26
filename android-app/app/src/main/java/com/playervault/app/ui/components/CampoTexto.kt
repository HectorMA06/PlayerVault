package com.playervault.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.playervault.app.ui.theme.PlayervaultTheme
import com.playervault.app.ui.theme.Variables

@Composable
fun CampoTexto(
    titulo: String,
    valor: String,
    onValorChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValorChange,
        modifier = modifier,
        label = { Text(text = titulo) },
        singleLine = true,
        shape = RoundedCornerShape(Variables.shapeMedium),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Variables.onSurface,
            unfocusedTextColor = Variables.onSurface,
            focusedContainerColor = Variables.surface,
            unfocusedContainerColor = Variables.surface,
            focusedBorderColor = Variables.primary,
            unfocusedBorderColor = Variables.outline,
            focusedLabelColor = Variables.primary,
            unfocusedLabelColor = Variables.onSurfaceVariant,
            cursorColor = Variables.primary
        )
    )
}

@Preview
@Composable
private fun CampoTextoPrev() {
    var texto by remember { mutableStateOf("") }
    PlayervaultTheme {
        CampoTexto(
            titulo = "Título",
            valor = texto,
            onValorChange = { texto = it }
        )
    }
}
