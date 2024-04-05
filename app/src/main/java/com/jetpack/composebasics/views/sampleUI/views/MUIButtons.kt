package com.jetpack.composebasics.views.sampleUI.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainMUI(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MUIButtons {
            onClick(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainMUIPreview() {
    MainMUI {}
}


@Composable
fun MUIButtons(onClick: (String) -> Unit) {
    Column {
        Button(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            onClick = {
                onClick("Button is Clicked")
            },
            shape = ButtonDefaults.elevatedShape,
            contentPadding = ButtonDefaults.TextButtonContentPadding
        ) {
            ButtonText("Button")
        }

        ElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onClick("ElevatedButton") },
        ) {
            ButtonText("ElevatedButton")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 20.dp),
                onClick = { onClick("ExtendedFloatingActionButton is Clicked") }
            ) {
                /*FloatingActionButton(onClick = {
                    onClick("FloatingActionButton is Clicked")
                }) {

                }*/
                ButtonText(text = "FloatingActionButton")

            }
        }
    }
}

@Composable
fun ButtonText(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 8.dp),
        text = text
    )
}

fun getToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}