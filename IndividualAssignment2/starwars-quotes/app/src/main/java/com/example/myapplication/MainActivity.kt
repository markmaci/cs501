package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.R

data class Quote(val text: String, val character: String, val movie: String)

val quotes = listOf(
    // Light side quotes
    Quote(
        text = "“Do or do not. There is no try.”",
        character = "Yoda",
        movie = "The Empire Strikes Back"
    ),
    Quote(
        text = "“The Force will be with you, always.”",
        character = "Obi-Wan Kenobi",
        movie = "A New Hope"
    ),
    Quote(
        text = "“Your focus determines your reality.”",
        character = "Qui-Gon Jinn",
        movie = "The Phantom Menace"
    ),
    Quote(
        text = "“I am a Jedi, like my father before me.”",
        character = "Luke Skywalker",
        movie = "Return of the Jedi"
    ),
    Quote(
        text = "“Fear is the path to the dark side. Fear leads to anger, anger leads to hate, hate leads to suffering.”",
        character = "Yoda",
        movie = "The Phantom Menace"
    ),
    Quote(
        text = "“In my experience, there's no such thing as luck.”",
        character = "Obi-Wan Kenobi",
        movie = "A New Hope"
    ),
    Quote(
        text = "“The ability to speak does not make you intelligent.”",
        character = "Qui-Gon Jinn",
        movie = "The Phantom Menace"
    ),
    Quote(
        text = "“Confronting fear is the destiny of a Jedi. Your destiny.”",
        character = "Luke Skywalker",
        movie = "The Rise of Skywalker"
    ),
    Quote(
        text = "“Train yourself to let go of everything you fear to lose.”",
        character = "Yoda",
        movie = "Revenge of the Sith"
    ),
    Quote(
        text = "“You’ve taken your first step into a larger world.”",
        character = "Obi-Wan Kenobi",
        movie = "A New Hope"
    ),
    // Dark side quotes
    Quote(
        text = "“The circle is now complete. When I left you, I was but the learner. Now I am the master.”",
        character = "Darth Vader",
        movie = "A New Hope"
    ),
    Quote(
        text = "“You underestimate the power of the dark side. If you will not fight, then you will meet your destiny.”",
        character = "Darth Vader",
        movie = "Return of the Jedi"
    ),
    Quote(
        text = "“Everything that has transpired has done so according to my design.”",
        character = "Emperor Palpatine",
        movie = "Return of the Jedi"
    ),
    Quote(
        text = "“You have controlled your fear. Now, release your anger. Only your hatred can destroy me.”",
        character = "Darth Vader",
        movie = "Return of the Jedi"
    ),
    Quote(
        text = "“I am the Senate.”",
        character = "Darth Sidious (Emperor Palpatine)",
        movie = "Revenge of the Sith"
    ),
    Quote(
        text = "“Twice the pride, double the fall.”",
        character = "Count Dooku",
        movie = "Revenge of the Sith"
    ),
    Quote(
        text = "“At last we will reveal ourselves to the Jedi. At last we will have revenge.”",
        character = "Darth Maul",
        movie = "The Phantom Menace"
    ),
    Quote(
        text = "“Once more, the Sith will rule the galaxy! And we shall have peace.”",
        character = "Darth Sidious (Emperor Palpatine)",
        movie = "Revenge of the Sith"
    ),
    Quote(
        text = "“It is your destiny. Join me, and together we can rule the galaxy as father and son!”",
        character = "Darth Vader",
        movie = "The Empire Strikes Back"
    ),
    Quote(
        text = "“Your faith in your friends is yours. Your faith in the dark side of the Force is mine.”",
        character = "Darth Sidious (Emperor Palpatine)",
        movie = "Return of the Jedi"
    )
)


val StarWarsFont = FontFamily(
    Font(
        resId = R.font.frabk,
        weight = FontWeight.Normal
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuoteApp(modifier: Modifier = Modifier) {
    var currentQuote by remember { mutableStateOf(quotes.random()) }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.starfield),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            QuoteText(quote = currentQuote)

            Button(
                onClick = { currentQuote = quotes.random() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5BB4FF)),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    "Change Quote",
                    color = Color.White,
                    fontFamily = StarWarsFont,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun QuoteText(quote: Quote) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = quote.text,
            color = Color(0xFF5BB4FF),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = StarWarsFont,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, ambientColor = Color.Black, spotColor = Color.Black)
        )
        Spacer(modifier = Modifier.height(240.dp))
        Text(
            text = "- ${quote.character}",
            color = Color(0xFF5BB4FF),
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontFamily = StarWarsFont,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, ambientColor = Color.Black, spotColor = Color.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "(${quote.movie})",
            color = Color(0xFF5BB4FF),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontFamily = StarWarsFont,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, ambientColor = Color.Black, spotColor = Color.Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    MyApplicationTheme {
        QuoteApp()
    }
}