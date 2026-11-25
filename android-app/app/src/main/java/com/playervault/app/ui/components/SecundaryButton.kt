package com.playervault.app.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playervault.app.ui.theme.Variables

@Composable
fun SecundaryButton(text: String, onClick: () -> Unit,modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            border = BorderStroke(width = 1.dp ,color = Variables.outline),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Variables.primary
            ),
            shape = RoundedCornerShape(Variables.shapeFull),
            contentPadding = PaddingValues(horizontal = 24.dp),

        ) {
            Text(
                text = text
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun SecundaryButtonPrev() {
    SecundaryButton("Guardar", {})
}