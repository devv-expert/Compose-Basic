package com.jetpack.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        /*Order matters in the Modifier in the compose*/
        modifier = Modifier
            /* For the Height and with we can use
            * height() , width()
            * size(width, height)
            * match_parent --> fillMaxHeight()
            * and there is another method for the height and width called preferredHeight() and preferredWidth()
            * */
            .height(100.dp)
            .width(240.dp)
            /*To add the CLick on the Text view we use the Clickable function in the compose*/
            .clickable { }
            .padding(start = 20.dp, top = 10.dp)
            .padding(vertical = 10.dp, horizontal = 20.dp),
        /*Apart from the Modifier we have the Style attribute for the Styling the Text
        * Below text design is custom styling*/

        /*style = TextStyle(
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
        )*/

        /*here we are using the Google Material theme Typography
        * for the Text Styling*/
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Blue,
        fontWeight = FontWeight.SemiBold,
        fontSize = TextUnit.Unspecified
    )
    /*In the JetPack Compose there is no Margin Section*/
}

@Composable
fun mainScreen() {
    /*Surface is like ViewGroup of XLM class in compose inside the Surface we can define our view */
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        /*In Column and Row we can use the multiple surfaces or views*/
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                /*Here we are using the same composable Surface function again for code re-usability*/
                colorBox(Color.Yellow)
                colorBox(Color.Magenta)
            }
//          Here we are using the same composable Surface function again for code re-usability
            colorBox(Color.Cyan)
            colorBox(Color.Blue)
            colorBox(Color.Red)
        }
    }
}

@Composable
fun colorBox(color: Color) {
    /*This surface contain the Text view inside it*/
    Surface(
        color = color,
        /*Here we can align the Surface inside  wrapContentSize */
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
    ) {
        /*Text(
            text = " Hello Main Screen",
            style = MaterialTheme.typography.headlineMedium
        )*/
    }
}

@Composable
fun button() {
    Button(onClick = { }) {
        Greeting(name = "Button")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    mainScreen()
}