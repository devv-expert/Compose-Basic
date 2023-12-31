package com.jetpack.composebasics

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.composebasics.viewModel.MainViewModel

val nameList: ArrayList<String> = arrayListOf("Amit", "Ajay", "Billu", "Rubby")

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(context = this)
//            Yes data
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel(), context: Context) {
    /*Here we are using the State to changes the data in the List or add or remove the Data from the List
* Remember keyword remember the state after it's change*/

    val greetingListState = remember {
        mutableStateListOf<String>("Amit", "Billu", "Rubby")
    }
    /*onValueChange is lambda function is define what we are typing on the Keyboard*/
    /*Here now the observeAsState now changing the LiveData to the State to observe the State changes direct from the UI State*/
    val newNameStateContent =
        viewModel.textFieldState.observeAsState("") /*remember { mutableStateOf("") }*/

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            /*GreetingList(greetingListState, {
                greetingListState.add(newNameStateContent.value)
            }, newNameStateContent.value, { newName ->
                newNameStateContent.value = newName
            })*/

            /*Now here we don't have to pass the lambda function
            * now we can pass the viewModel dataChange Function who observe the livaData*/
            GreetingMessage(newNameStateContent.value , context) { newText ->
                /*Here our viewModel taking care of the Data and State changes on the UI state*/
                viewModel.onTextChange(newText)
            }
        }
    }
}

@Composable
fun GreetingMessage(textFieldValue: String,context : Context, textFieldUpdate: (String) -> Unit) {
    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
    Button(onClick = {  }) {
        Text(text = textFieldValue)

    }

}

@Composable
fun GreetingList(
    namesList: List<String>,
    clickButton: () -> Unit,
    textFieldValue: String,
    textFieldUpdate: (String) -> Unit
) {
    val StringValue = remember {
        mutableStateOf("")
    }

    var nameTF = TextFieldValue("")
    var stringT = ""

    for (names in namesList) {
        Greeting2(name = names)
    }
    /*TextField is the Editable text of the compose but it cannot the take care of there on state change so we have to take care of the state changes of the TextFiled
    * Using the stateManagement
    * here the mutableStateOf function will take care of the after we change the value of the compose
    Here we are updating the TextField by using the .value function which we are getting from the lambda function*/
    TextField(
        value = textFieldValue, onValueChange = textFieldUpdate
    )

    TextField(value = nameTF, onValueChange = { newValue ->

    })
    TextField(value = StringValue.value, onValueChange = { newValue ->

    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))


    Button(
        onClick = clickButton,
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
//    MainScreen()
}