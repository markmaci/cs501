package com.example.facts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facts.ui.theme.FactsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactsApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val StarWarsFont = FontFamily(
    Font(
        resId = R.font.frabk,
        weight = FontWeight.Normal
    )
)

@Composable
fun FunFactsApp(modifier: Modifier = Modifier) {
    val funFacts = listOf(
        "The phrase 'I have a bad feeling about this' is spoken in every Star Wars movie.",
        "Yoda was originally going to be played by a monkey wearing a mask.",
        "The sound of a TIE Fighter engine is a mix of an elephant call and a car driving on wet pavement.",
        "Chewbacca’s voice is a mix of bears, walruses, lions, and badgers.",
        "The word 'Wookiee' came from an ad-lib during the filming of THX 1138.",
        "The Star Wars Holiday Special marked Boba Fett’s first appearance.",
        "The Ewok language is based on Tibetan and Nepalese languages.",
        "Harrison Ford was not the first choice to play Han Solo. Burt Reynolds was also considered.",
        "Luke Skywalker was originally named Luke Starkiller.",
        "Darth Vader’s breathing sound was created by a scuba regulator.",
        "The Millennium Falcon’s shape was inspired by a hamburger.",
        "R2-D2 originally spoke English and had actual lines of dialogue.",
        "The character of Han Solo was originally envisioned as a green-skinned alien.",
        "The X-wing and TIE Fighter sounds were made by blending animal and mechanical sounds.",
        "E.T. makes a cameo appearance in 'The Phantom Menace'.",
        "Jabba the Hutt was originally a humanoid character in early drafts of 'A New Hope'.",
        "David Prowse, who played Darth Vader, is banned from Star Wars conventions.",
        "Mark Hamill held his breath for a long time to film the trash compactor scene in 'A New Hope'.",
        "Yoda’s species has never been officially named.",
        "The opening crawl in 'A New Hope' took three hours to shoot.",
        "Liam Neeson is so tall they had to build special sets for his character Qui-Gon Jinn.",
        "In the original trilogy, Darth Vader only appears on screen for a total of 12 minutes.",
        "The voice of General Grievous is also the sound designer for the Star Wars prequels.",
        "Carrie Fisher slapped Oscar Isaac over 40 times while filming 'The Last Jedi'.",
        "The word 'Jedi' comes from the Japanese word 'Jidai Geki,' which refers to period dramas.",
        "The actors who portrayed C-3PO and R2-D2 did not get along during filming.",
        "Ewan McGregor made lightsaber sounds with his mouth while filming 'The Phantom Menace'.",
        "In 'The Empire Strikes Back', Mark Hamill had to bang his head 16 times on Yoda's hut door.",
        "Samuel L. Jackson requested a purple lightsaber so he could easily spot himself in battle scenes.",
        "The sound of the seismic charge from 'Attack of the Clones' was inspired by a high-speed racecar zoom."
    )

    var currentFactIndex by remember { mutableStateOf(Random.nextInt(funFacts.size)) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Did You Know?",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = StarWarsFont,
                color = Color(0xFF5BB4FF),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, ambientColor = Color.Black, spotColor = Color.Black)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = funFacts[currentFactIndex],
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = StarWarsFont,
                color = Color(0xFF5BB4FF),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, ambientColor = Color.Black, spotColor = Color.Black)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    currentFactIndex = (currentFactIndex + 1) % funFacts.size
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5BB4FF)
                ),
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(0.6f)
            ) {
                Text(
                    text = "Next Fact",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = StarWarsFont
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsPreview() {
    FactsTheme {
        FunFactsApp()
    }
}
