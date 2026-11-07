package com.example.askly.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.askly.data.viewmodel.AuthViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    LaunchedEffect(Unit) {
        if (viewModel.isLogin()) {
            navController.navigate("professorDashboard")
        } else {
            navController.navigate("menu")
        }
    }
}