package com.playervault.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.playervault.app.ui.theme.PlayervaultTheme
import com.playervault.app.ui.theme.Variables

@Composable
fun CampoTexto(
    titulo: String,
    valor: String,
    onValorChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    esContrasena: Boolean = false
) {

    var contrasenaVisible by remember { mutableStateOf(false) }

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
        ),
        // Solo se ocultan los caracteres si es un campo de contraseña y no se ha pulsado el ojo
        visualTransformation = if (esContrasena && !contrasenaVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (esContrasena) KeyboardType.Password else KeyboardType.Text
        ),
        // El icono del ojo solo aparece en los campos de contraseña
        trailingIcon = if (esContrasena) {
            {
                IconButton(onClick = { contrasenaVisible = !contrasenaVisible }) {
                    Icon(
                        imageVector = if (contrasenaVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = if (contrasenaVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    )
                }
            }
        } else {
            null
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun CampoTextoPrev() {
    var texto by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    PlayervaultTheme {
        Column {
            CampoTexto(
                titulo = "Email",
                valor = texto,
                onValorChange = { texto = it }
            )
            CampoTexto(
                titulo = "Contraseña",
                valor = password,
                onValorChange = { password = it },
                esContrasena = true
            )
        }
    }
}
