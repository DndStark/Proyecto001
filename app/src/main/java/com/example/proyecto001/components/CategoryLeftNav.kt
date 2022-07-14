package com.example.proyecto001.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.proyecto001.R

@Composable
fun CategoryLeftNav(usuario: String) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserData(usuario)
        Divider(modifier = Modifier.width(300.dp), color = colorResource(id = R.color.color07), thickness = 1.dp)
        MenuList()
        Divider(modifier = Modifier.width(300.dp), color = colorResource(id = R.color.color07), thickness = 1.dp)
        LogOutButton()
    }
}

@Composable
fun UserData(usuario: String){
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://miguelmedina.online/img/minions43.jpg"),
            contentDescription = "Cat Logo",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.padding(top = 30.dp)) {
            Text(text = "Bienvenido $usuario", fontWeight = FontWeight.Bold)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "miguelmedina@unsa.edu.pe", fontSize = 12.sp)
        }
    }
}

@Composable
fun MenuList(){
    LazyColumn(
        modifier = Modifier
            .height(350.dp)
            .width(280.dp)
            .padding(top = 15.dp, bottom = 15.dp)
    ) {
        item { AddItem("Categorías", Icons.Rounded.GridOn)}
        item { AddItem("Historia", Icons.Rounded.History)}
        item { AddItem("Config. Ingresos", Icons.Rounded.ManageAccounts)}
        item { AddItem("Estadísticas", Icons.Rounded.StackedBarChart)}
        item { DividerHorizontal() }
        item { AddItem("Mensajes", Icons.Rounded.Send)}
        item { DividerHorizontal()}
        item { AddItem("Exportar", Icons.Rounded.SaveAlt)}
        item { AddItem("Redes Sociales", Icons.Rounded.People)}
        item { DividerHorizontal()}
        item { AddItem("Configuración", Icons.Rounded.Settings)}
    }



}

@Composable
fun DividerHorizontal() {
    Divider(
        modifier = Modifier
            .width(250.dp)
            .padding(5.dp),
        color = colorResource(id = R.color.color07),
        thickness = 1.dp
    )
}

@Composable
fun AddItem(nameCat: String, iconPath: ImageVector){
    Row (
        modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.End
        ) {
        Icon(iconPath, contentDescription = nameCat)
        Text(
            text = nameCat,
            modifier = Modifier.padding(start = 15.dp),
            fontSize = 20.sp
        )
    }
}

@Composable
fun LogOutButton(){
    Button(onClick = {
        //navController.navigate(route = AppScreens.LoginActivity.route)
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.color07)),
    ) {
        Icon(Icons.Rounded.Logout, contentDescription = "Salir")
        Text(text = stringResource(id = R.string.Logout_button), color = Color.Black)
    }
}