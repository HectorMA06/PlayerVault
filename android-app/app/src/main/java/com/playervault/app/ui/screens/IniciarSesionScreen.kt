package com.playervault.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.playervault.app.R
import com.playervault.app.ui.components.CampoTexto
import com.playervault.app.ui.components.PrimaryButton
import com.playervault.app.ui.theme.Roboto
import com.playervault.app.ui.theme.Variables
import com.playervault.app.ui.theme.background
import com.playervault.app.ui.theme.onSurface
import com.playervault.app.ui.theme.onSurfaceVariant

@Composable
fun IniciarSesion(modifier: Modifier = Modifier) {
    var texto by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    //Iniciar sesion
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        //Status Bar
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .width(360.dp)
                .height(28.dp)
                .padding(start = 24.dp, end = 24.dp)
        ) {

        }
        //"SPACER"
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .width(10.dp)
                .height(56.dp)
                .align(Alignment.CenterHorizontally)
        ) {

        }
        //Marca
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .width(312.dp)
                .height(220.dp)
                .padding(bottom = 24.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            //LOGO
            Image(
                painter = painterResource(R.drawable.ic_playervault_logo),
                contentDescription = "Logo de playervault",
                modifier = modifier
                    .width(80.dp)
                    .height(80.dp),

            )
            //Nombre de la App
            Text(
                text = stringResource(R.string.app_name),
                style = TextStyle(
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(700),
                    color = onSurface
                ),
                modifier = modifier
                    .width(145.dp)
                    .height(36.dp)
            )
            //Eslogan
            Text(
                text = stringResource(R.string.eslogan),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = onSurfaceVariant,
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .width(205.dp)
                    .height(48.dp)
            )
        }
        //Email campo texto
        CampoTexto(
            titulo = "Email",
            valor = texto,
            onValorChange = {texto = it},
            modifier = Modifier
                .width(312.dp)
                .align(Alignment.CenterHorizontally)
        )
        //Contraseña
        CampoTexto(
            titulo = "Contraseña",
            valor = password,
            onValorChange = {password = it},
            esContrasena = true,
            modifier = Modifier
                .width(312.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(
            text = "Iniciar sesión",
            onClick = {},
            modifier = Modifier
                .width(312.dp)
                .height(48.dp)
                .align(Alignment.CenterHorizontally)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(top = 16.dp)
                .width(312.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "¿No tienes cuenta?",

                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Variables.onSurfaceVariant,
                ),
            )

            Text(
                text = "Regístrate",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(500),
                    color = Variables.primary,
                )
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview (showBackground = true)
@Composable
private fun IniciarSesionPrev() {
    IniciarSesion()
}