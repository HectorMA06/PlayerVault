package com.playervault.app


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.playervault.app.ui.screens.IniciarSesion

@Composable
fun PlayerVaultApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { innerpadding ->
        IniciarSesion(modifier = Modifier
            .padding(innerpadding))
    }
}

@Preview
@Composable
private fun PlayerVaultAppPrev() {
    PlayerVaultApp()
}