package com.example.askly.screens

import android.R.attr.onClick
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.askly.R
import com.example.askly.ui.theme.QuestionMarkIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                QuestionMarkIcon()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Askly",
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Askly Logo Icon",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(22.dp)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Outlined.Forum,
                contentDescription = "Menu Screen Icon",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Ask without",
                style = MaterialTheme.typography.displayMedium.copy(
                    letterSpacing = (-0.8).sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Text(
                text = "raising a hand.",
                style = MaterialTheme.typography.displayMedium.copy(
                    letterSpacing = (-0.8).sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Submit questions anonymously during a lecture. " +
                        "Your professor sees the question,\n" +
                        "but not your name.",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            onClick = { navController.navigate("studentDashboard") }
        ) {
            Text(
                text = "I'm a student",
                fontSize = 18.sp,
                modifier = Modifier.padding(6.dp)
            )
        }
        Spacer( modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            onClick = { navController.navigate("signIn") }
        ) {
            Text(
                text = "I'm a professor",
                fontSize = 18.sp,
                modifier = Modifier.padding(6.dp)
            )
        }
        Spacer( modifier = Modifier.height(20.dp))
    }
}