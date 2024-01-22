package com.jetpack.composebasics.views.profileUI

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.jetpack.composebasics.dataClass.UserProfiles
import com.jetpack.composebasics.dataClass.userProfiles
import com.jetpack.composebasics.views.profileUI.ui.theme.MyTheme

class ProfileUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UserApplication()
            }
        }
    }
}

@Composable
fun UserApplication(userData: List<UserProfiles> = userProfiles) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") {
            UserList(userData, navController)
        }
        composable(
            route = "user_details_screen/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) { NavBackStackEntry ->
            UserProfile(NavBackStackEntry.arguments!!.getInt("userId"), navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    UserList(userData = userProfiles, navController = null)
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    UserProfile(0, null)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserList(userData: List<UserProfiles>, navController: NavController?) {
    Scaffold(topBar = { AppBar("User List", Icons.Default.Home) {} }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp)
        ) {
            /*the Lazy Column is the Same thing as the RecyclerView in the Android with XML and it's also recycle the view for the Better performance*/
            LazyColumn(modifier = Modifier.padding(top = 65.dp)) {
                items(userData) { userProfiles ->
                    ProfileCard(userData = userProfiles) {
                        navController?.navigate("user_details_screen/${userProfiles.id}")
                    }
                }
            }

        }
    }
}

@Composable
fun ProfileCard(userData: UserProfiles, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .clickable { clickAction.invoke() },
        colors = CardDefaults.cardColors(
            Color.Cyan
        ), elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            ProfilePicture(userData.userImage, userData.status, 70.dp)
            ProfileContent(userData.name, userData.status, Alignment.Start)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfilePicture(imageURL: String, isActiveStatus: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape, border = BorderStroke(
            4.dp, color = if (isActiveStatus) Color.Green else Color.Red
        ), modifier = Modifier.padding(15.dp)
    ) {
        Image(painter = rememberImagePainter(data = imageURL, builder = {
            transformations(CircleCropTransformation())
        }), modifier = Modifier.size(imageSize), contentDescription = "Profile picture")
    }
}

@Composable
fun ProfileContent(userName: String, isActiveStatus: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalAlignment = alignment
    ) {
        Text(
            text = userName,
            modifier = Modifier.padding(top = 5.dp),
            style = MaterialTheme.typography.headlineSmall
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
fun AppBar(appBarTitle: String, icon: ImageVector, backButtonAction: () -> Unit) {
    TopAppBar(title = { Text(text = appBarTitle) }, navigationIcon = {
        Icon(
            imageVector = icon,
            contentDescription = "App Bar",
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clickable { backButtonAction.invoke() }
        )
    }, colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserProfile(userId: Int, navController: NavController?) {
    val userProfile = userProfiles.first { userData -> userId == userData.id }
    Scaffold(topBar = {
        AppBar(appBarTitle = "User Profile", Icons.Default.ArrowBack) {
            navController?.navigateUp()
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 65.dp),
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile.userImage, userProfile.status, 240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
            }
        }
    }
}