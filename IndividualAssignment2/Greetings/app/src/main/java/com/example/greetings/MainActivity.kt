package com.example.greetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetings.ui.theme.GreetingsTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GreetingApp(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("What's your name?") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            greeting = generateGreeting(name)
        }) {
            Text("Greet Me in Italian")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (greeting.isNotEmpty()) {
            Text(
                text = greeting,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

fun generateGreeting(name: String): String {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val timeOfDay = when (currentHour) {
        in 5..11 -> "Buongiorno"
        in 12..17 -> "Buon pomeriggio "
        in 18..21 -> "Buonasera"
        else -> "Diocane, vai a dormire "
    }
    return "$timeOfDay, $name!"
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingsTheme {
        GreetingApp()
    }
}
