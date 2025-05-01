package com.example.demo1.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demo1.data.model.CatFact
import com.example.demo1.presentation.viewmodel.CatViewModel

@Composable
fun CatScreen(viewModel: CatViewModel = hiltViewModel()) {

    val catFacts = viewModel.catFacts.collectAsState()


    Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {

        LazyColumn {
            items(catFacts.value) {
                    items ->
                CatFactItem(items)
            }
        }
        Button(onClick = { viewModel.fetchRandomDogImage() },
            modifier = Modifier.padding(10.dp).align(Alignment.BottomCenter)
            ) {
            Text("Add Cat Fact")
        }

    }
}

@Composable
fun CatFactItem(catFact: CatFact) {
    Card(modifier = Modifier.fillMaxWidth().padding(10.dp),
        colors = CardDefaults.cardColors(contentColor = Color.Cyan)
        ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = catFact.fact, style = MaterialTheme.typography.bodyLarge, color = Color.Black )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Length: ${catFact.length}", style = MaterialTheme.typography.bodyMedium,color = Color.Blue)
        }
    }
}