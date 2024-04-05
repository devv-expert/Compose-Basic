package com.jetpack.composebasics.androidPermissions

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.jetpack.composebasics.androidPermissions.ui.theme.ComposeBasicsTheme

@OptIn(ExperimentalPermissionsApi::class)
class PermissionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val permissionState = rememberMultiplePermissionsState(
                permissions = listOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.RECORD_AUDIO
                )
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                permissionState.permissions.forEach { currentPermission ->

                    when (currentPermission.permission) {
                        Manifest.permission.CAMERA -> {
                            when {
                                currentPermission.hasPermission -> {

                                }

                                currentPermission.shouldShowRationale -> {

                                }

                                !currentPermission.hasPermission && !currentPermission.shouldShowRationale -> {

                                }
                            }
                        }

                        Manifest.permission.RECORD_AUDIO -> {

                        }
                    }

                }

            }
        }
    }
}