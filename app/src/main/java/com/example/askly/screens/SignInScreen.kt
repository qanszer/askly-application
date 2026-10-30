package com.example.askly.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.askly.ui.theme.AsklyDimensions
import com.example.askly.ui.theme.QuestionMarkIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen (navController: NavController) {
    val dimensions = AsklyDimensions.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        // Custom Top Bar
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CompositionLocalProvider(
                LocalMinimumInteractiveComponentEnforcement provides false) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        // Content Area
        Column(
            modifier = Modifier.padding(horizontal = dimensions.screenPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 160.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuestionMarkIcon(
                    modifier = Modifier.size(80.dp),
                    fontSize = 55.sp
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Sign in to create",
                    fontSize = 40.sp,
                    letterSpacing = (-0.8).sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "a classroom",
                    fontSize = 40.sp,
                    letterSpacing = (-0.8).sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Only professors need an account. It ties each classroom " +
                            "and its join code to you, so nobody else can moderate your " +
                            "questions.",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(54.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                onClick = { navController.navigate("professorDashboard") }
            ) {
                Text(
                    text = "Continue with Google",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(6.dp)
                )
            }
            Spacer( modifier = Modifier.height(20.dp))
        }
    }
}