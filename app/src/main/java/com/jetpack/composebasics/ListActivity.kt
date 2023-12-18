package com.jetpack.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val nameList: ArrayList<String> = arrayListOf("Amit", "Ajay", "Billu", "Rubby")

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            GreetingList()
        }
    }
}

@Composable
fun GreetingList() {
    /*Here we are using the State to changes the data in the List or add or remove the Data from the List
    * Remember keyword remember the state after it's change*/
    val greetingListState = remember {
        mutableStateListOf<String>("Amit", "Billu", "Rubby")
    }

    for (names in greetingListState) {
        Greeting2(name = names)
    }

    Button(
        onClick = { greetingListState.add("Add new member") },
        modifier = Modifier.padding(start = 5.dp, top = 5.dp)
    ) {
        Text("Click Me")
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(start = 5.dp, top = 5.dp),
        style = MaterialTheme.typography.headlineMedium
    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MainScreen()
}