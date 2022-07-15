package com.example.proyecto001.components

<<<<<<< HEAD
import android.content.Context
=======
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
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
<<<<<<< HEAD
fun CategoriesList(usuario: String?, context: Context) {
=======
fun CategoriesList(usuario: String?) {
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
    Column{
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                CategoryLeftNav(""+usuario)
            }
        ) {
<<<<<<< HEAD
            PrintCategory(usuario, context)
=======
            PrintCategory(usuario)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        }
    }
}

@Composable
<<<<<<< HEAD
fun PrintCategory(usuario: String?, context: Context){
=======
fun PrintCategory(usuario: String?){
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Bienvenido $usuario")
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 0.dp)
        ) {
<<<<<<< HEAD
            CategoryButton(grupo = "Comida", pathIcon = Icons.Rounded.ShoppingCart, context)
            CategoryButton(grupo = "Servicios Básicos", pathIcon = Icons.Rounded.ElectricalServices, context)
            CategoryButton(grupo = "Transporte", pathIcon = Icons.Rounded.EmojiTransportation, context)
=======
            CategoryButton(grupo = "Comida", pathIcon = Icons.Rounded.ShoppingCart)
            CategoryButton(grupo = "Servicios Básicos", pathIcon = Icons.Rounded.ElectricalServices)
            CategoryButton(grupo = "Transporte", pathIcon = Icons.Rounded.EmojiTransportation)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        }
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 0.dp)
        ) {
<<<<<<< HEAD
            CategoryButton(grupo = "Vestuario", pathIcon = Icons.Rounded.Checkroom, context)
            CategoryButton(grupo = "Aseo", pathIcon = Icons.Rounded.Soap, context)
            CategoryButton(grupo = "Salud", pathIcon = Icons.Rounded.MedicalServices, context)
=======
            CategoryButton(grupo = "Vestuario", pathIcon = Icons.Rounded.Checkroom)
            CategoryButton(grupo = "Aseo", pathIcon = Icons.Rounded.Soap)
            CategoryButton(grupo = "Salud", pathIcon = Icons.Rounded.MedicalServices)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        }
        Row(
            modifier = Modifier
                .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 0.dp)
        ) {
<<<<<<< HEAD
            CategoryButton(grupo = "Pasatiempo", pathIcon = Icons.Rounded.SportsEsports, context)
            CategoryButton(grupo = "Ahorro", pathIcon = Icons.Rounded.Savings, context)
            CategoryButton(grupo = "Sin categoría", pathIcon = Icons.Rounded.TouchApp, context)
=======
            CategoryButton(grupo = "Pasatiempo", pathIcon = Icons.Rounded.SportsEsports)
            CategoryButton(grupo = "Ahorro", pathIcon = Icons.Rounded.Savings)
            CategoryButton(grupo = "Sin categoría", pathIcon = Icons.Rounded.TouchApp)
>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
        }
    }
}

@Composable
<<<<<<< HEAD
fun CategoryButton(grupo: String, pathIcon: ImageVector, context: Context){
    Button(
        onClick = {
            val intent = Intent(context, ItemsActivity::class.java)
            intent.putExtra("grupo", grupo)
            context.startActivity(intent)
=======
fun CategoryButton(grupo: String, pathIcon: ImageVector){
    Button(
        onClick = {

>>>>>>> 85bb036a2d9c5c1798558e303dbcab3f26a15cc5
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