package com.example.proyecto001.components

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.proyecto001.CategoryActivity
import com.example.proyecto001.ItemsActivity
import com.example.proyecto001.R
import com.example.proyecto001.navegation.AppNavigation


@Composable
fun CategoriesList(usuario: String?) {
    Column{
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                CategoryLeftNav(""+usuario)
            }
        ) {
            PrintCategory(usuario)
        }
    }
}

@Composable
fun PrintCategory(usuario: String?){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Bienvenido $usuario")
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 0.dp)
        ) {
            CategoryButton(grupo = "Comida", pathIcon = Icons.Rounded.ShoppingCart)
            CategoryButton(grupo = "Servicios Básicos", pathIcon = Icons.Rounded.ElectricalServices)
            CategoryButton(grupo = "Transporte", pathIcon = Icons.Rounded.EmojiTransportation)
        }
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 0.dp)
        ) {
            CategoryButton(grupo = "Vestuario", pathIcon = Icons.Rounded.Checkroom)
            CategoryButton(grupo = "Aseo", pathIcon = Icons.Rounded.Soap)
            CategoryButton(grupo = "Salud", pathIcon = Icons.Rounded.MedicalServices)
        }
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 0.dp)
        ) {
            CategoryButton(grupo = "Pasatiempo", pathIcon = Icons.Rounded.SportsEsports)
            CategoryButton(grupo = "Ahorro", pathIcon = Icons.Rounded.Savings)
            CategoryButton(grupo = "Sin categoría", pathIcon = Icons.Rounded.TouchApp)
        }
    }
}

@Composable
fun CategoryButton(grupo: String, pathIcon: ImageVector){
    Button(
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.color07)),
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(4.dp))
            .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
    ){
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(pathIcon, contentDescription = "Icon")
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = grupo,
                fontSize = 11.sp,
                textAlign = TextAlign.Center)
        }
    }
}