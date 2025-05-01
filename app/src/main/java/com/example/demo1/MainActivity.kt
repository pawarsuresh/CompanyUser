package com.example.demo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo1.presentation.navigation.AppNavigation
import com.example.demo1.ui.theme.Demo1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demo1Theme {
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  }