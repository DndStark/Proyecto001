package com.example.proyecto001

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyecto001.database.entities.Item
import com.example.proyecto001.database.utils.*
import com.example.proyecto001.database.view.ItemViewFactory
import com.example.proyecto001.database.view.ViewItem
import com.example.proyecto001.ui.theme.Proyecto001Theme

class ItemsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto001Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BodyItemActivity("Android")
                }
            }
        }
    }
}

@Composable
fun BodyItemActivity(grupo: String?){
    val context = LocalContext.current

    val viewItem: ViewItem = viewModel(
        factory = ItemViewFactory(context.applicationContext as Application)
    )

    val items = viewItem.readAllData.observeAsState(listOf()).value

    var nombre by remember{ mutableStateOf("") }
    var monto by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Divider(modifier = Modifier.padding(10.dp))
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
                //navController.navigate(route = AppScreens.GroupsActivity.route +"/"+ "Miguel")
                val ite: Item = Item(""+nombre, ""+monto, ""+grupo)
                viewItem.insertItem(ite)
            }) {
            Text(text = "Guardar")
        }
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .height(500.dp)
                .width(280.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(modifier = Modifier
                .height(350.dp)
                .width(280.dp)
                .padding(top = 5.dp)
            ){
                ItemList(list = items, viewItem = viewItem)
            }
        }
    }
}

@Composable
fun ItemList(list: List<Item>, viewItem: ViewItem){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .offset(y = (-20).dp)
            .width(450.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 15.dp
    ){
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            items(list){item ->
                Itemm(item, CatIcon(item.itemCate), viewItem)
            }
        }
    }
}

@Composable
fun Itemm(item: Item, iconPath: ImageVector, viewItem: ViewItem){
    Row (
        modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Icon(iconPath, contentDescription = item.itemName)
        Text(
            text = item.itemName,
            modifier = Modifier.padding(start = 15.dp).width(100.dp),
            fontSize = 20.sp
        )
        Text(
            text = item.itemMont,
            modifier = Modifier.padding(start = 15.dp).width(40.dp),
            fontSize = 20.sp
        )
        IconButton(
            onClick = {
                viewItem.deleteItem(item)
            },
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(4.dp))
        ){
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Rounded.Delete, contentDescription = "Delete")
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }
    }
}

fun CatIcon(nameCate: String): ImageVector {
    var icon: ImageVector = Icons.Rounded.ShoppingCart

    when (nameCate){
        SERVICIOS_BASICOS   -> icon = Icons.Rounded.ElectricalServices
        TRANSPORTE          -> icon = Icons.Rounded.EmojiTransportation
        VESTUARIO           -> icon = Icons.Rounded.Checkroom
        ASEO                -> icon = Icons.Rounded.Soap
        SALUD               -> icon = Icons.Rounded.MedicalServices
        PASATIEMPO          -> icon = Icons.Rounded.SportsEsports
        AHORRO              -> icon = Icons.Rounded.Savings
        SIN_CATEGORIA       -> icon = Icons.Rounded.TouchApp
    }
    return icon
}