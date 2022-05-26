package com.example.proyecto001.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto001.navegation.AppScreens

@Composable
fun FormActivity(navController: NavController, grupo: String?){
    var nombre by remember{ mutableStateOf("") }
    var monto by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Se guardará en la categoría $grupo")
        Divider(modifier = Modifier.padding(10.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Descripción gasto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Divider(modifier = Modifier.padding(10.dp))
        TextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Divider(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
                navController.navigate(route = AppScreens.GroupsActivity.route +"/"+ "Miguel")
            }) {
            Text(text = "Guardar")
        }


    }
}

@Composable
fun SubGroupButton(text: String){
    Button(onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}