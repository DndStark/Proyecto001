package com.example.proyecto001.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto001.R
import com.example.proyecto001.navegation.AppScreens

@Composable
fun LoginActivity(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color07)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .offset(y = (-20).dp)
                .width(350.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 15.dp
        ) {
            Column(
                modifier = Modifier
                    .width(350.dp)
                    .height(450.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
                    .background(Color.White)
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("M")
                        }
                        append("is ")

                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("F")
                        }
                        append("inanzas ")

                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)) {
                            append("P")
                        }
                        append("ersonales")
                    },
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Divider(modifier = Modifier.width(280.dp),color = colorResource(id = R.color.color07), thickness = 1.dp)
                Image(
                    painter = painterResource(id = R.drawable.finanzas_login),
                    contentDescription = "Cat Logo",
                    modifier = Modifier
                        .size(300.dp)
                )
                GoogleButton(navController)

            }
        }
    }

}

@Composable
fun GoogleButton(navController: NavController){
    Button(onClick = {
            navController.navigate(route = AppScreens.GroupsActivity.route +"/"+ "Miguel")
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.color07)),
    ) {
        Image(
            modifier = Modifier.padding(1.dp),
            painter = painterResource(id = R.drawable.ic_google_foreground),
            contentDescription = "Google")
        Text(text = stringResource(id = R.string.google_button), color = Color.Black)
    }
}
