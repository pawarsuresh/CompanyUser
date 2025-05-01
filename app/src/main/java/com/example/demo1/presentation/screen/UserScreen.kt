package com.example.demo1.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.demo1.presentation.viewmodel.UserViewmodel

@Composable
fun UserScreen(navController: NavController,viewmodel: UserViewmodel= hiltViewModel()) {
    var user = viewmodel.user.collectAsState()
    LazyColumn(modifier = Modifier.padding(top = 120.dp)) {
        items(user.value) { items->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Column(modifier = Modifier.padding(10.dp).clickable{
                    navController.navigate("userDetail/${items.id}")
                }) {
                    Text(
                        text = "Name : ${items.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(5.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "Email : ${items.email}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(5.dp),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "Phone : ${items.phone}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(5.dp),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSetup(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "User Information")},
          colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
            )
    }) { paddingValue ->
        Column(modifier = Modifier.padding(paddingValue)) {  }
        UserScreen(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUser(){
    TopAppBarSetup(navController = rememberNavController())
}