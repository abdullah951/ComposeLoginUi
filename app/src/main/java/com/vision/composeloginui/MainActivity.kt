package com.vision.composeloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material.TextField as TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vision.composeloginui.ui.theme.ComposeLoginUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoginUiTheme {
                LoginUi()
            }
        }
    }
}

@Composable
fun LoginUi() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "BackgroundIcon",
            modifier = Modifier
                .fillMaxWidth()
                .width(150.dp)
                .height(150.dp),

            )
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        Text(text = "Login", style = MaterialTheme.typography.h5)
        TextField(
            value = email,
            onValueChange = { it->
                email = it
            },
            modifier = Modifier
                .background(color = Color.White)
                .height(60.dp)
                .border(
                    width = 1.dp,
                    Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                ),
            label = {
                Text("Email",fontSize = 12.sp)
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Email,
                    "EmailIcon"
                )
            },
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor =  Color.White, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLoginUiTheme {
        LoginUi()
    }
}