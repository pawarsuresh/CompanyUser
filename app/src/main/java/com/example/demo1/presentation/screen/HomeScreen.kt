package com.example.demo1.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {navController.navigate("userList")}, modifier = Modifier.width(200.dp)) {
            Text(text = "User Model",)
        }
        Button(onClick = {navController.navigate("CatDetail")}, modifier = Modifier.width(200.dp)) {
            Text(text = "Cat Model")
        }

    }

}