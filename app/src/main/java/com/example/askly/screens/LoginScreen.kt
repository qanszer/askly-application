package com.example.askly.screens

import android.widget.Toast
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.askly.data.viewmodel.AuthViewModel
import com.example.askly.ui.theme.AsklyDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen (
    navController: NavController,
    viewModel: AuthViewModel
) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    .padding(top = 100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Log in to your account",
                    style = MaterialTheme.typography.displayMedium.copy(
                        letterSpacing = (-0.8).sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it},
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it},
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(42.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    onClick = {
                        viewModel.login(email, password) { success, result ->
                            if (success) {
                                navController.navigate("professorDashboard")
                            } else {
                                Toast.makeText(
                                    context,
                                    "Invalid email or password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
            Spacer( modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = { navController.navigate("register") }
                ) {
                    Text("Don't have an account? Sign up")
                }
            }
            Spacer( modifier = Modifier.height(20.dp))
        }
    }
}