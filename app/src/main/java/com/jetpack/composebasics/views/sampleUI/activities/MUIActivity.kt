package com.jetpack.composebasics.views.sampleUI.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpack.composebasics.NavigationComp.MUI_BUTTONS
import com.jetpack.composebasics.views.sampleUI.views.MainMUI
import com.jetpack.composebasics.views.sampleUI.views.getToast

class MUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MUINavigation(this@MUIActivity)
        }
    }
}

@Composable
fun MUINavigation(context: MUIActivity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MUI_BUTTONS) {
        composable(MUI_BUTTONS) {
            MainMUI {
                getToast(context, it)
            }
        }
    }
}