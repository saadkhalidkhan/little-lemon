package com.droidgeeks.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi

@ExperimentalGlideComposeApi
@Composable
fun NavigationComposable(context: Context) {
    val navController = rememberNavController()
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val isLoggedIn = sharedPreferences.getBoolean("userRegistered", false)
    NavHost(
        navController = navController,
        startDestination =
        if (isLoggedIn) {
            Home.route
        } else {
            Onboarding.route
        }
    ) {
        composable(Home.route) {
            Home(navController)
        }
        composable(Onboarding.route) {
            Onboarding(context, navController)
        }
        composable(Profile.route) {
            Profile(context, navController)
        }
    }
}