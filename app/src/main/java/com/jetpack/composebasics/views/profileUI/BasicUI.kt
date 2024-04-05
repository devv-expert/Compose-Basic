package com.jetpack.composebasics.views.profileUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldCompose() {
    val text = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            label = {
                Text(text = text.value)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 10.dp),
            placeholder = { Text(text = "Add Text here....") }
        )
    }
}