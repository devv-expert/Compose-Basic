@file:Suppress("UNUSED_EXPRESSION")

package com.jetpack.composebasics.views.profileUI

import android.annotation.SuppressLint
import android.graphics.Paint.Style
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.composebasics.R
import com.jetpack.composebasics.dataClass.UserData
import com.jetpack.composebasics.views.profileUI.ui.theme.MyTheme
import java.security.Provider

class ProfileUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp)
        ) {
            Column(modifier = Modifier.padding(top = 60.dp)) {
                ProfileCard(userData = UserData("Amit", true, R.drawable.profile_picture))
                ProfileCard(userData = UserData("Ravi", false, R.drawable.ic_launcher_foreground))
                ProfileCard(userData = UserData("Akshit", true, R.drawable.ic_launcher_background))
                ProfileCard(userData = UserData("Sandeep", false, R.drawable.profile_picture))

            }
        }
    }
}

@Composable
fun ProfileCard(userData: UserData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),

        colors = CardDefaults.cardColors(
            Color.Cyan
        ), elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            ProfilePicture(userData.userImageId, userData.isActive)
            ProfileContent(userData.userName, userData.isActive)
        }
    }
}

@Composable
fun ProfilePicture(userImageId: Int, isActiveStatus: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            4.dp,
            color = if (isActiveStatus) Color.Green else Color.Red
        ),
        modifier = Modifier.padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = userImageId),
            contentDescription = "",
            modifier = Modifier.size(75.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent(userName: String, isActiveStatus: Boolean) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = userName,
            modifier = Modifier.padding(top = 5.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = if (isActiveStatus) "Active" else "offline",
            modifier = Modifier.alpha(alpha = 0.5f),
            style = MaterialTheme.typography.titleMedium
        )
    }

}

@ExperimentalMaterial3Api
@Composable
fun AppBar() {
    val appBarTitle = "Top App Bar"
    TopAppBar(
        title = { Text(text = appBarTitle) },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "App Bar",
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
    )
}