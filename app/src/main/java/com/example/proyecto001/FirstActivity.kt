package com.example.proyecto001

import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

class FirstActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message: String? = intent.getStringExtra("message")
        val url: String? = intent.getStringExtra("url")
        setContent {
            Content(message, url)
        }
    }
}


@Composable
fun Content(message: String?, url: String?) {

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
                            append("No")
                        }
                        append("ti")

                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("fi")
                        }
                        append("ca ")

                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)) {
                            append("ci")
                        }
                        append("ón")
                    },
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp,
                    color = Color.Black

                )
                Divider(modifier = Modifier.width(280.dp),color = colorResource(id = R.color.color07), thickness = 1.dp)
                Text(
                    text = ""+message
                )
                Image(
                    painter = rememberAsyncImagePainter("" + url),
                    contentDescription = "Cat Logo",
                    modifier = Modifier
                        .size(300.dp)
                )
            }
        }
    }

}