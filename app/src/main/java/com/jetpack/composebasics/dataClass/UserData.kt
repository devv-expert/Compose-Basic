package com.jetpack.composebasics.dataClass

import com.jetpack.composebasics.R

data class UserData(val userName: String, val isActive: Boolean, val userImageId: Int)

val userProfiles = arrayListOf(
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Amit", false, R.drawable.profile_picture),
    UserData("Ravi", true, R.drawable.ic_launcher_foreground),
    UserData("Akshit", false, R.drawable.ic_launcher_background),
    UserData("Sandeep", true, R.drawable.profile_picture),
    UserData("Anuj", false, R.drawable.profile_picture)
)
