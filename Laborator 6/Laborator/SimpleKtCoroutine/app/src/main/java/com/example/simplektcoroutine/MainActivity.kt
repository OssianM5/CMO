package com.example.simplektcoroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//import kotlinx.coroutines.DelicateCoroutinesApi


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CoroutineExampleApp()
/*
            SimpleKtCoroutineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
 */
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun CoroutineExampleApp() {
    // Cream un CoroutineScope legat de compoziția actuală
    //val scope = rememberCoroutineScope()
    val coroutineScope = rememberCoroutineScope()

    var text by remember { mutableStateOf("Așteptare...") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            text = "Se procesează..."
            coroutineScope.launch {
                val result = longRunningTask()
                text = result
            }
        }) {
            Text("Pornește Corutina")
        }
    }
}

suspend fun longRunningTask(): String {
    delay(3000) // Simulează o operațiune care durează 3 secunde
    return "Rezultatul operațiunii"
}