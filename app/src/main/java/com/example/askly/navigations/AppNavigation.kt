package com.example.askly.navigations

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.askly.models.AsklyViewModel
import com.example.askly.screens.CreateClassroomScreen
import com.example.askly.screens.JoinClassroomScreen
import com.example.askly.screens.MenuScreen
import com.example.askly.screens.ProfessorClassScreen
import com.example.askly.screens.ProfessorDashboardScreen
import com.example.askly.screens.StudentClassScreen
import com.example.askly.screens.StudentDashboardScreen

@Composable
fun AppNavigation () {
    val navrouting = rememberNavController()
    val asklyViewModel : AsklyViewModel = viewModel()

    NavHost(
        navController = navrouting,
        startDestination = "menu"
    ) {
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

//      Professor Screens
        composable("professorDashboard") {
            ProfessorDashboardScreen(navrouting)
        }
        composable("professorCreate") {
            CreateClassroomScreen(navrouting)
        }
        composable("professorClass") {
            ProfessorClassScreen(navrouting)
        }
    }
}