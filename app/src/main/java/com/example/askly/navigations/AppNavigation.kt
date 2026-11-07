package com.example.askly.navigations

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.askly.data.AsklyFactory
import com.example.askly.data.repository.AsklyRepository
import com.example.askly.data.repository.AuthRepository
import com.example.askly.data.viewmodel.AsklyViewModel
import com.example.askly.data.viewmodel.AuthViewModel
import com.example.askly.screens.CreateClassroomScreen
import com.example.askly.screens.JoinClassroomScreen
import com.example.askly.screens.LoginScreen
import com.example.askly.screens.MenuScreen
import com.example.askly.screens.ProfessorClassScreen
import com.example.askly.screens.ProfessorDashboardScreen
import com.example.askly.screens.RegisterScreen
import com.example.askly.screens.SignInScreen
import com.example.askly.screens.SplashScreen
import com.example.askly.screens.StudentClassScreen
import com.example.askly.screens.StudentDashboardScreen
import com.example.askly.screens.StudentEditScreen

@Composable
fun AppNavigation () {
    val navrouting = rememberNavController()
    val repository = AsklyRepository()
    val authrepo = AuthRepository()

    val asklyViewModel : AsklyViewModel = viewModel(
        factory = AsklyFactory(repository, authrepo)
    )

    val authViewModel : AuthViewModel = viewModel(
        factory = AsklyFactory(repository, authrepo)
    )

    NavHost(
        navController = navrouting,
        startDestination = "splash",
        enterTransition = { fadeIn(animationSpec = tween(0)) },
        exitTransition = { fadeOut(animationSpec = tween(0)) },
        popEnterTransition = { fadeIn(animationSpec = tween(0)) },
        popExitTransition = { fadeOut(animationSpec = tween(0)) },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        composable("login") {
            LoginScreen(navrouting, authViewModel)
        }
        composable("register") {
            RegisterScreen(navrouting, authViewModel)
        }
        composable("splash") {
            SplashScreen(navrouting, authViewModel)
        }
        composable("menu") {
            MenuScreen(navrouting)
        }

//      Student Screens
        composable("studentDashboard") {
            StudentDashboardScreen(navrouting, asklyViewModel)
        }
        composable("studentJoin") {
            JoinClassroomScreen(navrouting)
        }
        composable("studentClass") {
            StudentClassScreen(navrouting, asklyViewModel)
        }
        composable("studentEdit/{questionId}") {
                backStackEntry ->
                val id = backStackEntry.arguments
                ?.getString("questionId") ?: ""

            StudentEditScreen(id, navrouting, asklyViewModel)
        }

//      Professor Screens
        composable("signIn") {
            SignInScreen(navrouting)
        }
        composable("professorDashboard") {
            ProfessorDashboardScreen(navrouting, asklyViewModel)
        }
        composable("professorCreate") {
            CreateClassroomScreen(navrouting)
        }
        composable("professorClass") {
            ProfessorClassScreen(navrouting, asklyViewModel)
        }
    }
}